package com.Training.BookService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException {
    private String exceptionDetail;
    private Object value;

    public BookNotFoundException(String exceptionDetail,Long value){
        super(exceptionDetail+'-'+value);
        this.exceptionDetail=exceptionDetail;
        this.value=value;
    }

    public String getExceptionDetail() {
        return exceptionDetail;
    }

    public Object getValue() {
        return value;
    }
}
