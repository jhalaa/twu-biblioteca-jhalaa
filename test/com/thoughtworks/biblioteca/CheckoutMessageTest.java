package com.thoughtworks.biblioteca;

import org.junit.Test;
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
    public void shouldCallMyPrinterMethodOnUnsuccessfulCheckoutOfBooks() {
        Printer printer = mock(Printer.class);
        CheckoutMessage checkoutMessage = new CheckoutMessage(printer);
        checkoutMessage.printUnsuccessfulBookCheckoutMessage();
        verify(printer).printMessage("That book is not available");
    }
    @Test
    public void shouldCallMyPrinterMethodOnSuccessfulCheckoutOfMovies() {
        Printer printer = mock(Printer.class);
        CheckoutMessage checkoutMessage = new CheckoutMessage(printer);
        checkoutMessage.printSuccessfulMovieCheckoutMessage();
        verify(printer).printMessage("Thank you! Enjoy the movie");
    }
    @Test
    public void shouldCallMyPrinterMethodOnUnsuccessfulCheckoutOfMovies() {
        Printer printer = mock(Printer.class);
        CheckoutMessage checkoutMessage = new CheckoutMessage(printer);
        checkoutMessage.printUnsuccessfulMovieCheckoutMessage();
        verify(printer).printMessage("That movie is not available");
    }
}
