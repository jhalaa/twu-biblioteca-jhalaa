package com.thoughtworks.biblioteca;

import java.util.ArrayList;

//displays a list of books
public class BookList {

    private ArrayList<Book> books = new ArrayList<Book>();

    public void printMessage() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void addBook(Book book) {
        books.add(book);
    }
}
