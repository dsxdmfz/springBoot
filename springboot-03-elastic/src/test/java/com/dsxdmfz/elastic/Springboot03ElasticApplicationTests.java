package com.dsxdmfz.elastic;

import com.dsxdmfz.elastic.Repository.BookRepository;
import com.dsxdmfz.elastic.bean.Article;
import com.dsxdmfz.elastic.bean.Book;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot03ElasticApplicationTests {

    @Autowired
    JestClient jestClient;

    @Autowired
    BookRepository bookRepository;

    @Test
    public void test(){
//        Book book = new Book();
//        book.setId(1);
//        book.setBookName("雪中悍刀行");
//        book.setAuthor("烽火戏诸侯");
//        bookRepository.index(book);

        List<Book> list = bookRepository.findByBookNameLike("雪");
        for (Book book: list
             ) {
            System.out.println(book);
        }
    }

    @Test
    public void contextLoads() {

        //给es中索引（保存）一个文档
        Article article = new Article();
        article.setId(1);
        article.setTitle("好消息");
        article.setAuthor("Catrina");
        article.setContent("hello world");

        //构建一个索引功能
        Index index = new Index.Builder(article).index("dsxdmfz").type("news").build();

        try {
            //执行
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //测试搜索
    @Test
    public void search(){

        //查询表达式
        String searchStr = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"hello\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        //构建搜索功能
        Search search = new Search.Builder(searchStr).addIndex("dsxdmfz").addType("news").build();

        //执行
        try {
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
