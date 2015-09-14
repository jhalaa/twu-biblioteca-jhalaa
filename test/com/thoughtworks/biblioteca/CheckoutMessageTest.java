package com.thoughtworks.biblioteca;

import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

//displays appropriate checkout message
public class CheckoutMessageTest {

    @Test
    public void shouldCallMyPrinterMethodWithTrue() {
        Printer printer = mock(Printer.class);
        CheckoutMessage checkoutMessage = new CheckoutMessage(printer);
        checkoutMessage.printSuccessfulMessage();
        verify(printer).printMessage("Thank you! Enjoy the book");
    }

    @Test
    public void shouldCallMyPrinterMethodWithFalse() {
        Printer printer = mock(Printer.class);
        CheckoutMessage checkoutMessage = new CheckoutMessage(printer);
        checkoutMessage.printUnsuccessfulMessage();
        verify(printer).printMessage("That book is not available");
    }
}
