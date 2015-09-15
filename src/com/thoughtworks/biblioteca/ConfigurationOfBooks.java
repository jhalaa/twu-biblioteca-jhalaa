package com.thoughtworks.biblioteca;

import java.util.ArrayList;

//sets up biblioteca
public class ConfigurationOfBooks {
    private Welcome welcome;
    private ArrayList<Book> books;
    private BookLibrary bookLibrary;
    private Printer printer = new Printer(System.out);

    public BookLibrary start() {
        welcome = new Welcome("Hello BookLibrary lover!Welcome to biblioteca",printer);
        welcome.printMessage();
        books = new ArrayList<Book>();
        books.add(new Book("Harry Potter", "JK Rowling", 1993));
        books.add(new Book("Da Vinci Code", "Dan Brown", 2007));
        books.add(new Book("Atlas shrugged", "Ayn Rand", 1990));
        books.add(new Book("Emma", "Jane Austen", 1890));
        books.add(new Book("Hitchicker's guide to galaxy", "Douglas Adams", 1989));
        bookLibrary = new BookLibrary(books);
        return bookLibrary;
    }
}
