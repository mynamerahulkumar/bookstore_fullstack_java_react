package com.book.bookstoreonline.controller;

import com.book.bookstoreonline.controllers.BookController;
import com.book.bookstoreonline.dtos.BookDTO;
import com.book.bookstoreonline.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class BookControllerTest {

    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;

    @Test
    private  void getBookListTest(){
        List<BookDTO> bookDTOS=new ArrayList<>();
        bookDTOS.add(getBookDto());
        when(bookService.getBooks()).thenReturn(bookDTOS);
       ResponseEntity< List<BookDTO>> bookDtolist= (ResponseEntity<List<BookDTO>>) bookController.getBookList();
        Assertions.assertEquals(bookDtolist.getBody().size(),1);
    }

    private BookDTO getBookDto(){
        return BookDTO.builder().title("Java").description("Java Programming").releaseYear(2021).build();
    }

}
