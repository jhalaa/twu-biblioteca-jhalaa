package com.thoughtworks.biblioteca;

public class BookDetails {

    private String bookName;
    private String author;
    private int year;
    public BookDetails(String bookName, String author, int year) {
        this.bookName = bookName;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString()
    {
        return bookName+" "+author+" "+year;
    }
}
