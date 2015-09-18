package com.thoughtworks.biblioteca;

import java.util.ArrayList;

//sets up biblioteca
public class ConfigurationOfBooks {
    private static final String INVALID_LIBRARY_NUMBER = "0";
    private static final String INVALID_PASSWORD = "0";
    private static final String UNKNOWN_NAME = "0";
    private static final String UNKNOWN_EMAIL = "0";
    private static final String UNKNOWN_PHONENUMBER = "0";
    private Welcome welcome;
    private ArrayList<Book> books;
    private BookLibrary bookLibrary;
    private Printer printer = new Printer(System.out);
    private User user = new User(INVALID_LIBRARY_NUMBER, INVALID_PASSWORD, UNKNOWN_NAME, UNKNOWN_EMAIL, UNKNOWN_PHONENUMBER);

    public BookLibrary start() {
        welcome = new Welcome("Hello BookLibrary lover!Welcome to biblioteca", printer);
        welcome.printMessage();
        books = new ArrayList<Book>();

        books.add(new Book("Harry Potter", "JK Rowling", 1993, user));
        books.add(new Book("Da Vinci Code", "Dan Brown", 2007, user));
        books.add(new Book("Atlas shrugged", "Ayn Rand", 1990, user));
        books.add(new Book("Emma", "Jane Austen", 1890, user));
        books.add(new Book("Hitchicker's guide to galaxy", "Douglas Adams", 1989, user));
        bookLibrary = new BookLibrary(books);
        return bookLibrary;
    }
}
