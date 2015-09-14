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
        Printer printer = new Printer(System.out);
        CheckoutMessage checkoutMessage = new CheckoutMessage(true, printer);
        checkoutMessage.printMessage();
        assertEquals("Thank you! Enjoy the book", outContent.toString());
    }

    @Test
    public void shouldRetunValidMessageOnUnsuccessfulCheckout() {
        Printer printer = new Printer(System.out);
        CheckoutMessage checkoutMessage = new CheckoutMessage(false, printer);
        checkoutMessage.printMessage();
        assertEquals("That book is not available", outContent.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
    }


}
