package com.thoughtworks.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BookListTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setOutputStream() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldReturnValidBook() {
        BookList bookList = new BookList();
        bookList.addBook(new Book("Harry Potter", "JK Rowling", 1993));
        bookList.printMessage();
        assertEquals("Harry Potter JK Rowling 1993\n", outContent.toString());
    }

    @Test
    public void shouldReturnValidBooks() {
        BookList bookList = new BookList();
        bookList.addBook(new Book("Harry Potter", "JK Rowling", 1993));
        bookList.addBook(new Book("Da Vinci Code", "Dan Brown", 2007));
        bookList.printMessage();
        assertEquals("Harry Potter JK Rowling 1993\nDa Vinci Code Dan Brown 2007\n", outContent.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
    }
}
