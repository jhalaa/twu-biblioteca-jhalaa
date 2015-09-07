package com.thoughtworks.biblioteca;

import java.util.ArrayList;

//displays a list of books
public class BookList {

    private ArrayList<Book> books = new ArrayList<Book>();

    public BookList(ArrayList<Book> books) {
        this.books = books;
    }

    public void printMessage() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Override
    public boolean equals(Object object) {
        BookList that = (BookList) object;
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
}
