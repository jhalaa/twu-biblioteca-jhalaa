package com.thoughtworks.biblioteca;

import java.util.ArrayList;

//handles a list of availableBooks
public class Library implements Operation {

    private ArrayList<Book> availableBooks = new ArrayList<Book>();
    private ArrayList<Book> checkedOutBooks = new ArrayList<Book>();
    public static final String UNKNOWN_AUTHOR = null;
    public static final int    UNKNOWN_YEAR = 0;
    public Library(ArrayList<Book> availableBooks) {
        this.availableBooks = availableBooks;
    }

    public void displayContents() {
        for (Book book : availableBooks) {
            System.out.println(book);
        }
    }

    @Override
    public boolean equals(Object object) {
        Library that = (Library) object;
        for (int i = 0; i < availableBooks.size(); i++) {
            if (!(this.availableBooks.get(i).equals(that.availableBooks.get(i))))
                return false;
        }
            return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 7 * hash + availableBooks.get(0).hashCode();
        return hash;
    }

    public void checkOutBook(String name) {
        Checkout checkout;
        Book book = new Book(name,UNKNOWN_AUTHOR,UNKNOWN_YEAR);
        if(availableBooks.contains(book)) {
            int index = availableBooks.indexOf(book);
            checkedOutBooks.add(availableBooks.get(index));
            availableBooks.remove(book);
            checkout = new Checkout(true);
            checkout.printMessage();
        }
        else {
            checkout = new Checkout(false);
            checkout.printMessage();
        }
    }

    public void returnBook(String bookname) {
        Book book = new Book(bookname, UNKNOWN_AUTHOR, UNKNOWN_YEAR);
        if(checkedOutBooks.contains(book)) {
            int index = checkedOutBooks.indexOf(book);
            availableBooks.add(checkedOutBooks.get(index));
            checkedOutBooks.remove(book);
        }
    }
}
