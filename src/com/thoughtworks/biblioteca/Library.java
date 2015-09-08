package com.thoughtworks.biblioteca;

import java.util.ArrayList;

//handles a list of books
public class Library implements Operation {

    private ArrayList<Book> books = new ArrayList<Book>();
    public static final String UNKNOWN_AUTHOR = null;
    public static final int    UNKNOWN_YEAR = 0;
    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public void displayContents() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Override
    public boolean equals(Object object) {
        Library that = (Library) object;
        for (int i = 0; i < books.size(); i++) {
            if (!(this.books.get(i).equals(that.books.get(i))))
                return false;
        }
            return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 7 * hash + books.get(0).hashCode();
        return hash;
    }

    public void checkOutContent(String name) {
        Checkout checkout;
        Book book = new Book(name,UNKNOWN_AUTHOR,UNKNOWN_YEAR);
        if(books.contains(book)) {
            books.remove(book);
            checkout = new Checkout(true);
            checkout.printMessage();
        }
        else
           checkout = new Checkout(false);
            checkout.printMessage();
    }
}
