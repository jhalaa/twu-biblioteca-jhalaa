package com.thoughtworks.biblioteca;

import java.util.ArrayList;

//sets up biblioteca
public class Configuration {
    Welcome welcome;
    ArrayList<Book> books;
    Library library;

    public Library start() {
        welcome = new Welcome("Hello Library lover!Welcome to biblioteca");
        welcome.printMessage();
        books = new ArrayList<Book>();
        books.add(new Book("Harry Potter", "JK Rowling", 1993));
        books.add(new Book("Da Vinci Code", "Dan Brown", 2007));
        library = new Library(books);
        return library;
    }
}
