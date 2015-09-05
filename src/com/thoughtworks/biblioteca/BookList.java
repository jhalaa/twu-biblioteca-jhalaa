package com.thoughtworks.biblioteca;

import java.util.ArrayList;

//displays a list of books
public class BookList {

    private ArrayList<BookDetails> books = new ArrayList<BookDetails>();

    public void printMessage() {
        for(BookDetails book:books) {
            System.out.println(book);
        }
    }

    public void addBook(BookDetails book) {
        books.add(book);
    }
}
