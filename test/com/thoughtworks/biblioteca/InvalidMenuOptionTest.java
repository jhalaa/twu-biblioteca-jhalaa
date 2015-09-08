package com.thoughtworks.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class InvalidMenuOptionTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setOutputStream() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldRetunValidMessageOnInvalidCommand() {
        InvalidMenuOption invalidMenuOption = new InvalidMenuOption();
        invalidMenuOption.displayContents();
        assertEquals("Invalid menu option\n", outContent.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
        System.out.println(" ");
    }
}
