package com.thoughtworks.biblioteca;

import java.util.ArrayList;

//displays a list of books
public class Book {

    private ArrayList<String> books = new ArrayList<String>();
    private int count = 0;

    public void printMessage() {
        for(int i=0;i<count;i++) {
            System.out.println(books.get(i));
        }
    }

    public void addBook(String book) {
        books.add(count, book);
        count ++;
    }
}
