package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

//displays appropriate checkout message
public class CheckoutMessageTest {

    @Test
    public void shouldCallMyPrinterMethodOnSuccessfulCheckoutOfBooks() {
        Printer printer = mock(Printer.class);
        CheckoutMessage checkoutMessage = new CheckoutMessage(printer);
        checkoutMessage.printSuccessfulBookCheckoutMessage();
        verify(printer).printMessage("Thank you! Enjoy the book");
    }

    @Test
    public void shouldPrintAppropriateMessageOnSuccessfulCheckoutOfBooks() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        Printer printer = new Printer(printStream);
        CheckoutMessage checkoutMessage = new CheckoutMessage(printer);
        checkoutMessage.printSuccessfulBookCheckoutMessage();
        assertEquals("Thank you! Enjoy the book\n", outputStream.toString());
    }

    @Test
    public void shouldCallMyPrinterMethodOnUnsuccessfulCheckoutOfBooks() {
        Printer printer = mock(Printer.class);
        CheckoutMessage checkoutMessage = new CheckoutMessage(printer);
        checkoutMessage.printUnsuccessfulBookCheckoutMessage();
        verify(printer).printMessage("That book is not available");
    }

    @Test
    public void shouldPrintAppropriateMessageOnUnsuccessfulCheckoutOfBooks() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        Printer printer = new Printer(printStream);
        CheckoutMessage checkoutMessage = new CheckoutMessage(printer);
        checkoutMessage.printUnsuccessfulBookCheckoutMessage();
        assertEquals("That book is not available\n", outputStream.toString());
    }
    @Test
    public void shouldCallMyPrinterMethodOnSuccessfulCheckoutOfMovies() {
        Printer printer = mock(Printer.class);
        CheckoutMessage checkoutMessage = new CheckoutMessage(printer);
        checkoutMessage.printSuccessfulMovieCheckoutMessage();
        verify(printer).printMessage("Thank you! Enjoy the movie");
    }
    @Test
    public void shouldPrintAppropriateMessageOnSuccessfulCheckoutOfMovies() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        Printer printer = new Printer(printStream);
        CheckoutMessage checkoutMessage = new CheckoutMessage(printer);
        checkoutMessage.printSuccessfulMovieCheckoutMessage();
        assertEquals("Thank you! Enjoy the movie\n", outputStream.toString());
    }
    @Test
    public void shouldCallMyPrinterMethodOnUnsuccessfulCheckoutOfMovies() {
        Printer printer = mock(Printer.class);
        CheckoutMessage checkoutMessage = new CheckoutMessage(printer);
        checkoutMessage.printUnsuccessfulMovieCheckoutMessage();
        verify(printer).printMessage("That movie is not available");
    }
    @Test
    public void shouldPrintAppropriateMessageOnUnsuccessfulCheckoutOfMovies() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        Printer printer = new Printer(printStream);
        CheckoutMessage checkoutMessage = new CheckoutMessage(printer);
        checkoutMessage.printUnsuccessfulMovieCheckoutMessage();
        assertEquals("That movie is not available\n", outputStream.toString());
    }
}
