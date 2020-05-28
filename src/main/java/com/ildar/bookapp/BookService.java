package com.ildar.bookapp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class BookService {

    private BookRepository bookRepository;

    public Book saveBook(Book book) {
        log.info("Inserting book {} into DB.", book.getName());
        return bookRepository.save(book);
    }

    public List<Book> getBooks() {
        log.info("Retrieving books.");
        return bookRepository.findAll();
    }
}
