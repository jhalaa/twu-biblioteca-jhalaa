package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class WelcomeTest {

    @Test
    public void shouldRetunValidMessageOnWelcome() {
        Printer printer = mock(Printer.class);
        Welcome welcome = new Welcome("Hello BookLibrary lover!Welcome to biblioteca",printer);
        welcome.printMessage();
      verify(printer).printMessage("Hello BookLibrary lover!Welcome to biblioteca");
    }
}