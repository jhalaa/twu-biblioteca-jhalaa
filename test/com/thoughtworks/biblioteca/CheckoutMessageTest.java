package com.thoughtworks.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class CheckoutMessageTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setOutputStream() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldRetunValidMessageOnSuccessfulCheckout() {
        CheckoutMessage checkoutMessage = new CheckoutMessage(true);
        checkoutMessage.printMessage();
        assertEquals("Thank you! Enjoy the book\n", outContent.toString());
    }

    @Test
    public void shouldRetunValidMessageOnUnsuccessfulCheckout() {
        CheckoutMessage checkoutMessage = new CheckoutMessage(false);
        checkoutMessage.printMessage();
        assertEquals("That book is not available\n", outContent.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
    }


}
