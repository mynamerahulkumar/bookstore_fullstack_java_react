package com.book.bookstoreonline.controller;

import com.book.bookstoreonline.BookstoreonlineApplication;
import com.book.bookstoreonline.dtos.BookDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest(classes = BookstoreonlineApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerTest1 {

    @LocalServerPort
     private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @Sql(scripts = {"classpath:datatest.sql"})
    void shouldReturnListofBooks(){
        BookDTO[] listOfbooks=restTemplate.getForObject("http://localhost:"+port+"/api/v1/booklist/",BookDTO[].class);
        Assertions.assertNotNull(listOfbooks);
        Assertions.assertEquals(1,listOfbooks.length);
    }
}
