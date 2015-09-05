package com.thoughtworks.biblioteca;

public class BibliotecaMain {

    public static void main(String[] args) {

        Welcome welcome = new Welcome("Hello BookList lover!Welcome to biblioteca");
        welcome.printMessage();

        BookList bookList = new BookList();
        bookList.addBook(new Book("Harry Potter","JK Rowling",1993));
        bookList.addBook(new Book("Da Vinci Code", "Dan Brown", 2007));
        bookList.printMessage();
    }
}
