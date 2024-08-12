package com.book.bookstoreonline.service;

import com.book.bookstoreonline.dtos.BookDTO;
import com.book.bookstoreonline.model.Book;
import com.book.bookstoreonline.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private ModelMapper mapper;
@Test
    void shouldReturnListOfBooKTest(){
        List<Book>books=new ArrayList<>();
        Book book=getBook();
        books.add(book);
        BookDTO bookDTO=getBookDto();
        when(bookRepository.findAll()).thenReturn(books);
        when(mapper.map(book,BookDTO.class)).thenReturn(bookDTO);
                List<BookDTO> bookDTOS=bookService.getBooks();
        assertEquals(0,bookDTOS.size());
    }

    private Book getBook(){
        return  Book.builder().title("Java").description("Java Programming").releaseYear(2021).build();
    }

    private BookDTO getBookDto(){
        return BookDTO.builder().title("Java").description("Java Programming").releaseYear(2021).build();
    }
}
