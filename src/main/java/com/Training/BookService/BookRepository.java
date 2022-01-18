package com.Training.BookService;

import com.Training.BookService.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface BookRepository extends JpaRepository<Book,Long> {

}
