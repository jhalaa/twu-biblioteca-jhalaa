package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ReturnBookMessageTest {

    @Test
    public void shouldCallMyPrinterMethodUsingTrue() {
        Printer printer = mock(Printer.class);
        ReturnBookMessage returnBookMessage = new ReturnBookMessage(printer);
        returnBookMessage.displayAvailableMessage();
        verify(printer).printMessage("Thank you for returning the book.");

    }

    @Test
    public void shouldCallMyPrinterMethodUsingFalse() {
        Printer printer = mock(Printer.class);
        ReturnBookMessage returnBookMessage = new ReturnBookMessage(printer);
        returnBookMessage.displayNotAvailableMessage();
        verify(printer).printMessage("That is not a valid book to return.");

    }


}
