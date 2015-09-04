package com.thoughtworks.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BookTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setOutputStream() {
        System.setOut(new PrintStream(outContent));
    }
    @Test
    public void shouldReturnValidBook() {
        Book book = new Book();
        book.addBook("Harry Potter");
        book.printMessage();
        assertEquals("Harry Potter\n", outContent.toString());
    }
    @Test
    public void shouldReturnValidBooks() {
        Book book = new Book();
        book.addBook("Harry Potter");
        book.addBook("Da Vinci Code");
        book.printMessage();
        assertEquals("Harry Potter\nDa Vinci Code\n", outContent.toString());
    }
    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
    }
}
