package com.thoughtworks.biblioteca;

import java.util.ArrayList;

//handles a list of availableBooks
public class BookLibrary {

    private ArrayList<Book> availableBooks = new ArrayList<Book>();
    private ArrayList<Book> checkedOutBooks = new ArrayList<Book>();
    private static final String UNKNOWN_AUTHOR = null;
    private static final int UNKNOWN_YEAR = 0;
    private Printer printer = new Printer(System.out);
    private User user = new User("0","0");

    BookLibrary(ArrayList<Book> availableBooks) {
        this.availableBooks = availableBooks;
    }

    public void displayContents() {
        for (Book book : availableBooks) {
            System.out.println(book);
        }
    }

    @Override
    public boolean equals(Object object) {
        BookLibrary that = (BookLibrary) object;
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

    public void checkOutBook(String name,User user) {
        CheckoutMessage checkoutMessage;
        Book book = new Book(name, UNKNOWN_AUTHOR, UNKNOWN_YEAR,user);
        if (availableBooks.contains(book)) {
            int index = availableBooks.indexOf(book);
            availableBooks.get(index).setUser(user);
            checkedOutBooks.add(availableBooks.get(index));
            availableBooks.remove(book);
            checkoutMessage = new CheckoutMessage(printer);
            checkoutMessage.printSuccessfulBookCheckoutMessage();
        } else {
            checkoutMessage = new CheckoutMessage(printer);
            checkoutMessage.printUnsuccessfulBookCheckoutMessage();
        }
    }

    public void returnBook(String bookname,User user) {
        ReturnBookMessage returnBookMessage;
        Book book = new Book(bookname, UNKNOWN_AUTHOR, UNKNOWN_YEAR,user);
        if (checkedOutBooks.contains(book)) {
            int index = checkedOutBooks.indexOf(book);
            if(checkedOutBooks.get(index).getUser().equals(user)) {
                availableBooks.add(checkedOutBooks.get(index));
                checkedOutBooks.remove(book);
                returnBookMessage = new ReturnBookMessage(printer);
                returnBookMessage.displayAvailableMessage();
            }
            else {
                returnBookMessage = new ReturnBookMessage(printer);
                returnBookMessage.displayNotAvailableMessage();
            }
        } else {
            returnBookMessage = new ReturnBookMessage(printer);
            returnBookMessage.displayNotAvailableMessage();
        }
    }
}
