package com.Training.BookService.controller;

import com.Training.BookService.entity.Book;
import com.Training.BookService.exception.BookNotFoundException;
import com.Training.BookService.serviceImpl.BookServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/books")
@RestController
@RefreshScope
@Api(value = "This is a Book management system. We can use below defined API's to create, delete, update and view books")
public class BookController {

    @Autowired
    BookServiceImpl bookServiceImpl;

    @GetMapping()
    @ApiOperation(value = "View all the books present",response = Book.class)
    public ResponseEntity<List<Book>> getAll(){
        log.info("Get all books(Book service)");
        List<Book> list=bookServiceImpl.getAllBooks();
        return  new ResponseEntity<List<Book>>(list,new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "View a book based on ID", response = Book.class)
    public ResponseEntity<Book> getBookById(
            @ApiParam(value = "bookId to find a book",required = true)
            @PathVariable(name = "id") Long id) throws BookNotFoundException {
        log.info("get book by id(book service)");
        Book bookEntity= bookServiceImpl.getBook(id);
        return  new ResponseEntity<Book>(bookEntity,new HttpHeaders(), HttpStatus.OK);
    }
    @PostMapping
    @ApiOperation(value = "Create a new book ", response = Book.class)
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        log.info("save book (book service)");
        Book newBook = bookServiceImpl.createBook(book);
        return new ResponseEntity<Book>(newBook,new HttpHeaders(),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    @ApiOperation(value = "Update a book via ID ", response = Book.class)
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        log.info("update book (book service)");
        Book updatedBook = bookServiceImpl.updateBook(book);
        return new ResponseEntity<Book>(updatedBook, new HttpHeaders(),HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a book via ID ", response = Book.class)
    public HttpStatus deleteBook(
            @ApiParam(value = "bookId to find a book",required = true)
            @PathVariable(name = "id") Long id){
        log.info("delete book (book service)");
        bookServiceImpl.deleteBook(id);
        return HttpStatus.OK;

    }

}
