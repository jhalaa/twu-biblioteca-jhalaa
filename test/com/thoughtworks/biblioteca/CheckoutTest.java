package com.thoughtworks.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class CheckoutTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setOutputStream() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldRetunValidMessageOnSuccessfulCheckout() {
        Checkout checkout = new Checkout(true);
        checkout.printMessage();
        assertEquals("Thank you! Enjoy the book\n", outContent.toString());
    }

    @Test
    public void shouldRetunValidMessageOnUnsuccessfulCheckout() {
        Checkout checkout = new Checkout(false);
        checkout.printMessage();
        assertEquals("That book is not available\n", outContent.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
    }


}
