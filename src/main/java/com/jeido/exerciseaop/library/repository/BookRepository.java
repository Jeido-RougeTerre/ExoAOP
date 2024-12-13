package com.jeido.exerciseaop.library.repository;

import com.jeido.exerciseaop.library.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookRepository {
    private static BookRepository instance;
    private final Map<Integer, Book> books;
    private BookRepository() {
        books = new HashMap<>();
    }
    public static BookRepository getInstance() {
        if (instance == null) {
            instance = new BookRepository();
        }
        return instance;
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books.values());
    }

    public Book getBook(int id) {
        return books.get(id);
    }

    public Book save(Book book) {
        if (book.getId() == null) {
            book.setId(books.size());
        }
        books.put(book.getId(), book);
        return book;
    }

    public boolean removeBook(int id) {
        return books.remove(id) != null;
    }

}
