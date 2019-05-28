package com.dsxdmfz.elastic.Repository;

import com.dsxdmfz.elastic.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @Date: 2019/5/28
 * @Auther: lez
 */
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {

    //自定义方法
    //参照：https://docs.spring.io/spring-data/elasticsearch/docs/3.1.8.RELEASE/reference/html/
    //https://docs.spring.io/spring-data/elasticsearch/docs/3.1.8.RELEASE/reference/html/#elasticsearch.query-methods
    List<Book> findByBookNameLike(String bookName);

}
