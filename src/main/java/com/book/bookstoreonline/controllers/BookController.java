package com.book.bookstoreonline.controllers;

import com.book.bookstoreonline.dtos.BookDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookController {

    @GetMapping("/booklist/")
    public List<BookDTO> getBookList(){
        BookDTO bookDTO=BookDTO.builder().title("Java 21 started").build();
        List<BookDTO> bookDTOS=new ArrayList<>();
        bookDTOS.add(bookDTO);
        return ResponseEntity.ok(bookDTOS).getBody();
    }
}
