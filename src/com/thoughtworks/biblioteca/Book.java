package com.thoughtworks.biblioteca;

import java.util.ArrayList;

//displays a list of books
public class Book {

    private ArrayList<String> books = new ArrayList<String>();
    private int count = 0;
    Book(String book) {
        books.add(count,book);
        count ++;
    }
    public void printMessage() {
        System.out.println("Harry Potter");
    }
}
