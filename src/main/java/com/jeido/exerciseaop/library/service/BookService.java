package com.jeido.exerciseaop.library.service;

import com.jeido.exerciseaop.library.annotation.AroundAnnotation;
import com.jeido.exerciseaop.library.annotation.ExceptionAnnotation;
import com.jeido.exerciseaop.library.entity.Book;
import com.jeido.exerciseaop.library.exception.BookAlreadyInDataBaseException;
import com.jeido.exerciseaop.library.exception.BookNotFoundException;
import com.jeido.exerciseaop.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository = BookRepository.getInstance();

    //CREATE
    @AroundAnnotation
    @ExceptionAnnotation
    public Book createBook(Book book) {

        if (book.getId() != null) throw new BookAlreadyInDataBaseException(book);
        return bookRepository.save(book);
    }

    //READ
    @AroundAnnotation
    public List<Book> getAllBooks() {
        return bookRepository.getBooks();
    }

    @AroundAnnotation
    @ExceptionAnnotation
    public Book getBookById(int id) {
        if (bookRepository.getBook(id) != null) {
            return bookRepository.getBook(id);
        } else {
            throw new BookNotFoundException(id);
        }
    }

    //DELETE
    @AroundAnnotation
    @ExceptionAnnotation
    public String deleteBook(int id) {
        if(bookRepository.removeBook(id)) {
            return "Book deleted";
        } else {
            throw new BookNotFoundException(id);
        }
    }
}
