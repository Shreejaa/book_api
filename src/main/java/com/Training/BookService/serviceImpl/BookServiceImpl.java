package com.Training.BookService.serviceImpl;

import com.Training.BookService.BookRepository;
import com.Training.BookService.entity.Book;
import com.Training.BookService.exception.BookNotFoundException;
import com.Training.BookService.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book createBook(Book book) {
        if(book.getBookid()!=null)
        {
               Book newBook = new Book();
               newBook.setBookid(book.getBookid());
               newBook.setIsbn(book.getIsbn());
               newBook.setPrice(book.getPrice());
               newBook.setGenre(book.getGenre());
               newBook.setAuthor(book.getAuthor());
               newBook.setTitle(book.getTitle());
               return bookRepository.save(newBook);
            } else {
                return bookRepository.save(book);
            }
        }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.saveAndFlush(book);
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> bookList =bookRepository.findAll();

        if (bookList.size()>0){
            return bookList;
        }else{
            return new ArrayList<Book>();
        }
    }

    @Override
    public Book getBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()){
            return optionalBook.get();
        }else{
            throw new BookNotFoundException("No book exists with id ",id);
        }
    }

    @Override
    public void deleteBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()){
            bookRepository.deleteById(id);
        }else{
            throw new BookNotFoundException("No book exists with id ",id);
        }
    }
}
