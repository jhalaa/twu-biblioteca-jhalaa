package com.thoughtworks.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

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
}
