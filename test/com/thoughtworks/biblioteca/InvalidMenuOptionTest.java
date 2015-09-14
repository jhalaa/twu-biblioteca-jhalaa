package com.thoughtworks.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class InvalidMenuOptionTest {

    @Test
    public void shouldRetunValidMessageOnWelcome() {
        Printer printer = mock(Printer.class);
        InvalidMenuOption invalidMenuOption = new InvalidMenuOption(printer);
        invalidMenuOption.displayMessage();
        verify(printer).printMessage("Invalid menu option");
    }
}
