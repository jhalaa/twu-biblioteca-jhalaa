package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ReturnBookMessageTest {

    @Test
    public void shouldCallMyPrinterMethodUsingTrue() {
        Printer printer = mock(Printer.class);
        ReturnBookMessage returnBookMessage = new ReturnBookMessage(true, printer);
        returnBookMessage.displayMessage();
        verify(printer).printMessage("Thank you for returning the book.");

    }

    @Test
    public void shouldCallMyPrinterMethodUsingFalse() {
        Printer printer = mock(Printer.class);
        ReturnBookMessage returnBookMessage = new ReturnBookMessage(false, printer);
        returnBookMessage.displayMessage();
        verify(printer).printMessage("That is not a valid book to return.");

    }


}
