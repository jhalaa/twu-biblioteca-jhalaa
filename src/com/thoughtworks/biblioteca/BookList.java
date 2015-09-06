package com.thoughtworks.biblioteca;

import java.util.ArrayList;

//displays a list of books
public class BookList {

    private ArrayList<Book> books = new ArrayList<Book>();

    public BookList(ArrayList<Book> books) {
        this.books = books;
    }

    public void printMessage() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
