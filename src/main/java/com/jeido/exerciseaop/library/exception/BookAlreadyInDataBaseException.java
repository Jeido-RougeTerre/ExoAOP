package com.jeido.exerciseaop.library.exception;

import com.jeido.exerciseaop.library.entity.Book;

public class BookAlreadyInDataBaseException extends RuntimeException {
    public BookAlreadyInDataBaseException(Book book) {
        super(String.format("Book with id %d is already in database !", book.getId()));
    }
}
