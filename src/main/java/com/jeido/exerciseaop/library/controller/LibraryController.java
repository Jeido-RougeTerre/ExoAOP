package com.jeido.exerciseaop.library.controller;

import com.jeido.exerciseaop.library.entity.Book;
import com.jeido.exerciseaop.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("api/library")
public class LibraryController {

    @Autowired
    BookService bookService;

    @PostMapping
    public void create() {
        bookService.createBook(new Book(
                "Henry pâtes au beurre",
                "Jaahd Goz",
                "Fantasy",
                LocalDate.parse("2024-12-12"),
                374,
                true,
                4.20
        ));
    }

    @GetMapping
    public String list() {
        List<Book> books = bookService.getAllBooks();
        return books.stream().map(Book::toString).collect(Collectors.joining("\n"));
    }

    @DeleteMapping
    public void delete() {
        bookService.deleteBook(0);
    }

}
