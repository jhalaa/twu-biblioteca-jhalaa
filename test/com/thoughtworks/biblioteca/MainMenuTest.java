package com.thoughtworks.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MainMenuTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setOutputStream() {
        System.setOut(new PrintStream(outContent));
    }
    @Test
    public void shouldDisplayTheMenu()
    {
        MainMenu mainMenu = new MainMenu();
        assertEquals(mainMenu.displayMenu(),"List of Books");
    }
    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
    }
}
