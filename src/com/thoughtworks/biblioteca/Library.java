package com.thoughtworks.biblioteca;

import java.util.ArrayList;

//handles a list of availableBooks
public class Library {

    private ArrayList<Book> availableBooks = new ArrayList<Book>();
    private ArrayList<Book> checkedOutBooks = new ArrayList<Book>();
    private static final String UNKNOWN_AUTHOR = null;
    private static final int UNKNOWN_YEAR = 0;
    private Printer printer = new Printer(System.out);

    Library(ArrayList<Book> availableBooks) {
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
        CheckoutMessage checkoutMessage;
        Book book = new Book(name, UNKNOWN_AUTHOR, UNKNOWN_YEAR);
        if (availableBooks.contains(book)) {
            int index = availableBooks.indexOf(book);
            checkedOutBooks.add(availableBooks.get(index));
            availableBooks.remove(book);
            checkoutMessage = new CheckoutMessage(true, printer);
            checkoutMessage.printMessage();
        } else {
            checkoutMessage = new CheckoutMessage(false, printer);
            checkoutMessage.printMessage();
        }
    }

    public void returnBook(String bookname) {
        ReturnBookMessage returnBookMessage;
        Book book = new Book(bookname, UNKNOWN_AUTHOR, UNKNOWN_YEAR);
        if (checkedOutBooks.contains(book)) {
            int index = checkedOutBooks.indexOf(book);
            availableBooks.add(checkedOutBooks.get(index));
            checkedOutBooks.remove(book);
            returnBookMessage = new ReturnBookMessage(printer);
            returnBookMessage.displayAvailableMessage();
        } else {
            returnBookMessage = new ReturnBookMessage(printer);
            returnBookMessage.displayNotAvailableMessage();
        }
    }
}
