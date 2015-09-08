package com.thoughtworks.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ReturnBookTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setOutputStream() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldPrintValidMessageOnsuccessfulReturn() {
        ReturnBook returnBook = new ReturnBook(true);
        returnBook.displayMessage();
        assertEquals("Thank you for returning the book.\n", outContent.toString());
    }

    @Test
    public void shouldPrintValidMessageOnUnsuccessfulReturn() {
        ReturnBook returnBook = new ReturnBook(false);
        returnBook.displayMessage();
        assertEquals("That is not a valid book to return.\n", outContent.toString());
    }

        @After
    public void cleanUpStreams() {
        System.setOut(System.out);
    }
}
