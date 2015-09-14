package com.thoughtworks.biblioteca;

import org.junit.Test;
import java.io.ByteArrayOutputStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckoutMessageTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void shouldCallMyPrinterMethodWithTrue() {
        Printer printer = mock(Printer.class);
        CheckoutMessage checkoutMessage = new CheckoutMessage(true, printer);
        checkoutMessage.printMessage();
        verify(printer).printMessage("Thank you! Enjoy the book");
    }

    @Test
    public void shouldCallMyPrinterMethodWithFalse() {
        Printer printer = mock(Printer.class);
        CheckoutMessage checkoutMessage = new CheckoutMessage(false, printer);
        checkoutMessage.printMessage();
        verify(printer).printMessage("That book is not available");
    }
}
