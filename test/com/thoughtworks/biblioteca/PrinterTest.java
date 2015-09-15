package com.thoughtworks.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PrinterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setOutputStream() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldPrintTheMessageItIsPassedWith() {
        Printer printer = new Printer(System.out);
        printer.printMessage("jhalaa");
        assertEquals("jhalaa", outContent.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
    }

    @Test
    public void shouldTest() throws IOException {
        OutputStream mockOutputStream = mock(OutputStream.class);
        String message = "message";
        doThrow(new IOException()).when(mockOutputStream).write(message.getBytes());
        Printer printer = new Printer(mockOutputStream);
        printer.printMessage(message);

        assertEquals("wdd\n", outContent.toString());
    }
}
