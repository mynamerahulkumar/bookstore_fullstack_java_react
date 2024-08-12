package com.book.bookstoreonline.repository;

import com.book.bookstoreonline.model.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.StreamSupport;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    @Sql(scripts = {"classpath:datatest.sql"})
    void shouldAbleToFetchAllRecords(){
        Iterable<Book> all=bookRepository.findAll();
      Long count=  StreamSupport.stream(all.spliterator(),false).count();
        Assertions.assertEquals(2,count);
    }
    @Test
    @Sql(scripts = {"classpath:datatest.sql"})
    void findByTitleTest(){
        List<Book>books=bookRepository.findByTitle("Java");
        Assertions.assertEquals(1,books.size());
    }
}
