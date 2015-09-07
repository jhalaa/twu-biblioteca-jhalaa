package com.thoughtworks.biblioteca;


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
        return String.format("%-34s %-34s %-34d",bookName,author,year);
    }

    @Override
    public boolean equals(Object object) {
        Book book = (Book)object;
        if(this.bookName.equals(book.bookName))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 7 * hash + this.bookName.hashCode();
        hash = 7 * hash + this.author.hashCode();
        return hash+year;
    }

}
