package com.book.bookstoreonline.service;

import com.book.bookstoreonline.dtos.BookDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    public List<BookDTO> getBooks(){
        return new ArrayList<>();
    }
}
