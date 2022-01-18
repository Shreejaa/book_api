/*
package com.Training.BookService;

import com.Training.BookService.entity.Book;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestControllerMethod extends BookServiceApplicationTests {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    public static Long deleteId;
    @Test()
    public void AgetAllBooks() throws Exception {
        String uri = "/books";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Book[] Booklist = super.mapFromJson(content, Book[].class);
        assertTrue(Booklist.length > 0);
    }
    @Test
    public void BcreateBook() throws Exception {
        String uri = "/books";
        Book book = new Book();
        book.setTitle("create book");
        book.setAuthor("j.k rowling");
        book.setIsbn("78945613456");
        book.setGenre("fantasy");
        book.setPrice(99.0);
        String inputJson = super.mapToJson(book);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        Book actualBook  = mapFromJson(content,Book.class);
        deleteId=actualBook.getBookid();
        book.setBookid(deleteId);
        assertEquals(actualBook, book);
    }
    @Test
    public void CupdateProduct() throws Exception {
        String uri = "/books/"+deleteId;
        Book book = new Book();
        book.setBookid(deleteId);
        book.setTitle("update book test");
        book.setAuthor("j.k rowling");
        book.setIsbn("78945613456");
        book.setGenre("fantasy");
        book.setPrice(99.0);
        String inputJson = super.mapToJson(book);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        Book actualBook  =mapFromJson(content,Book.class);
        book.setBookid(deleteId);
        assertEquals(actualBook, book);
    }
    @Test
    public void DdeleteProduct() throws Exception {
        String uri = "/books/"+deleteId;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
}
*/
