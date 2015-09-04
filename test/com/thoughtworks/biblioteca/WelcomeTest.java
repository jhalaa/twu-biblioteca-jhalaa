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
        System.out.print("Hello Book lover!Welcome to thoughtworks");
        assertEquals("Hello Book lover!Welcome to thoughtworks", outContent.toString());
    }
    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}
