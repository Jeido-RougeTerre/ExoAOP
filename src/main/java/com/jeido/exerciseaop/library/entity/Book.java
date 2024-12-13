package com.jeido.exerciseaop.library.entity;

import java.time.LocalDate;

public class Book {
    private Integer id;
    private String title;
    private String author;
    private String genre;
    private LocalDate publishDate;
    private int pages;
    private boolean available;
    private double price;

    public Book(String title, String author, String genre, LocalDate publishDate, int pages, boolean available, double price) {
        id = null;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publishDate = publishDate;
        this.pages = pages;
        this.available = available;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "'" + title + '\'' +
                " by " + author + ", " + genre +
                " (" + publishDate + ") " +
                pages + " pages " +
                ((available) ? "available" : "unavailable") +
                String.format(", %.2f$", price);
    }

    public static Book parse(String line) {
        String[] parts = line.split(",");
        String title = parts[0];
        String author = parts[1];
        String genre = parts[2];
        try {

            LocalDate publicationDate = LocalDate.parse(parts[3]);
            int pages = Integer.parseInt(parts[4]);
            boolean available = Boolean.parseBoolean(parts[5]);
            double price = Double.parseDouble(parts[6]);
            return new Book(title, author, genre, publicationDate, pages, available, price);
        } catch (Exception e) {
            return null;
        }
    }
}