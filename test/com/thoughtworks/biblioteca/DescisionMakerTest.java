package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class DescisionMakerTest {



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
        Library library = new Library(books);
        DecisionMaker decisionMaker = new DecisionMaker(library,scanner);
        decisionMaker.start();
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
        Library library = new Library(books);
        DecisionMaker decisionMaker = new DecisionMaker(library,scanner);
        decisionMaker.start();
        assertEquals("Thank you! Enjoy the book\n", outputStream.toString());
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
        Library library = new Library(books);
        DecisionMaker decisionMaker = new DecisionMaker(library,scanner);
        decisionMaker.start();
        assertEquals("That book is not available\n", outputStream.toString());
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
        Library library = new Library(books);
        library.checkOutBook("Harry Potter");
        DecisionMaker decisionMaker = new DecisionMaker(library,scanner);
        decisionMaker.start();
        assertEquals("Thank you! Enjoy the book\nThank you for returning the book.\n", outputStream.toString());
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
        Library library = new Library(books);
        library.checkOutBook("Harry Potter");
        DecisionMaker decisionMaker = new DecisionMaker(library,scanner);
        decisionMaker.start();
        assertEquals("Thank you! Enjoy the book\nThat is not a valid book to return.\n", outputStream.toString());
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
        Library library = new Library(books);
        DecisionMaker decisionMaker = new DecisionMaker(library,scanner);
        decisionMaker.start();
        assertEquals("Invalid menu option\n", outputStream.toString());
    }
}
