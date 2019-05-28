package com.dsxdmfz.elastic.Repository;

import com.dsxdmfz.elastic.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @Date: 2019/5/28
 * @Auther: lez
 */
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {

    List<Book> findByBookNameLike(String bookName);

}
