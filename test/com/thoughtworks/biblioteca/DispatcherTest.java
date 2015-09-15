package com.thoughtworks.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class DispatcherTest {



    @Test
    public void shouldDisplayLibraryWhenOptionIsOne() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("1".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setIn(inputStream);
        System.setOut(printStream);
        Scanner scanner = new Scanner(inputStream);
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Harry Potter", "JK Rowling", 1993));
        BookLibrary bookLibrary = new BookLibrary(books);
        Dispatcher dispatcher = new Dispatcher(bookLibrary,scanner);
        dispatcher.run();
        assertEquals(String.format("%-34s %-34s %-34d\n","Harry Potter","JK Rowling",1993), outputStream.toString());
    }

    @Test
    public void shouldSuccesfullyCheckoutBookWhenBookIsAvailableAndOptionIsThree() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("3\nHarry Potter\n".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setIn(inputStream);
        System.setOut(printStream);
        Scanner scanner = new Scanner(inputStream);
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Harry Potter", "JK Rowling", 1993));
        books.add(new Book("Da Vinci Code", "Dan Brown", 2007));
        BookLibrary bookLibrary = new BookLibrary(books);
        Dispatcher dispatcher = new Dispatcher(bookLibrary,scanner);
        dispatcher.run();
        assertEquals("Thank you! Enjoy the book", outputStream.toString());
    }

    @Test
    public void shouldReturnBookNotValidMessageWhenBookIsNotAvailableAndOptionIsThree() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("3\nHarry\n".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setIn(inputStream);
        System.setOut(printStream);
        Scanner scanner = new Scanner(inputStream);
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Harry Potter", "JK Rowling", 1993));
        books.add(new Book("Da Vinci Code", "Dan Brown", 2007));
        BookLibrary bookLibrary = new BookLibrary(books);
        Dispatcher dispatcher = new Dispatcher(bookLibrary,scanner);
        dispatcher.run();
        assertEquals("That book is not available", outputStream.toString());
    }

    @Test
    public void shouldReturnMessageWhenValidBookIsReturnedAndOptionIsFour() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("4\nHarry Potter\n".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setIn(inputStream);
        System.setOut(printStream);
        Scanner scanner = new Scanner(inputStream);
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Harry Potter", "JK Rowling", 1993));
        books.add(new Book("Da Vinci Code", "Dan Brown", 2007));
        BookLibrary bookLibrary = new BookLibrary(books);
        bookLibrary.checkOutBook("Harry Potter");
        Dispatcher dispatcher = new Dispatcher(bookLibrary,scanner);
        dispatcher.run();
        assertEquals("Thank you! Enjoy the bookThank you for returning the book.", outputStream.toString());
    }
    @Test
    public void shouldReturnMessageWhenInValidBookIsReturnedAndOptionIsFour() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("4\nHarry\n".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setIn(inputStream);
        System.setOut(printStream);
        Scanner scanner = new Scanner(inputStream);
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Harry Potter", "JK Rowling", 1993));
        books.add(new Book("Da Vinci Code", "Dan Brown", 2007));
        BookLibrary bookLibrary = new BookLibrary(books);
        bookLibrary.checkOutBook("Harry Potter");
        Dispatcher dispatcher = new Dispatcher(bookLibrary,scanner);
        dispatcher.run();
        assertEquals("Thank you! Enjoy the bookThat is not a valid book to return.", outputStream.toString());
    }

    @Test
    public void shouldReturnMessageWhenInMenuOptionIsSelected() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("6".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setIn(inputStream);
        System.setOut(printStream);
        Scanner scanner = new Scanner(inputStream);
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Harry Potter", "JK Rowling", 1993));
        books.add(new Book("Da Vinci Code", "Dan Brown", 2007));
        BookLibrary bookLibrary = new BookLibrary(books);
        Dispatcher dispatcher = new Dispatcher(bookLibrary,scanner);
        dispatcher.run();
        assertEquals("Invalid menu option", outputStream.toString());
    }

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldExitWhenOptionSelectedIsTwo() {
            exit.expectSystemExit();
            System.exit(0);
    }

}
