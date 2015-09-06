package com.thoughtworks.biblioteca;

//returns the details of a book
public class Book {

    private String bookName;
    private String author;
    private int year;

    public Book(String bookName, String author, int year) {
        this.bookName = bookName;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return bookName + " " + author + " " + year;
    }
}
