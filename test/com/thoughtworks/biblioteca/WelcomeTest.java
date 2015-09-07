package com.thoughtworks.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class WelcomeTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setOutputStream() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldRetunValidMessageOnWelcome() {
        Welcome welcome = new Welcome("Hello Library lover!Welcome to biblioteca");
        welcome.printMessage();
        assertEquals("Hello Library lover!Welcome to biblioteca\n", outContent.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
    }
}
