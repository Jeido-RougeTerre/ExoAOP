package com.jeido.exerciseaop.library.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(int id) {
        super(String.format("Book with id %d not found", id));
    }
}
