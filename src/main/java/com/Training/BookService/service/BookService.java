package com.Training.BookService.service;

import com.Training.BookService.entity.Book;

import java.util.List;

public interface BookService {

    Book createBook(Book book);

    Book updateBook(Book book);

    List<Book> getAllBooks();

    Book getBook(Long id);

    void deleteBook(Long id);

}
