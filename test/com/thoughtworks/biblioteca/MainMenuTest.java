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
    public void shouldDisplayTheListOfBooks() {
        MainMenu mainMenu = new MainMenu("1");
        assertEquals(mainMenu.displayMenu(), "List of Books");
    }

    @Test
    public void shouldDisplayInvalidMenuOption() {
        MainMenu mainMenu = new MainMenu("2");
        assertEquals(mainMenu.displayMenu(), "Select a valid option!");
    }

    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
    }
}
