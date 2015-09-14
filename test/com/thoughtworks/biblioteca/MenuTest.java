package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuTest {


    @Test
    public void shouldRetunValidMessageOnWelcome() {
        Printer printer = mock(Printer.class);
        Menu menu = new Menu(printer);
        menu.displayMenuOption();
        verify(printer).printMessage("1:List of books\t2:Exit\t3:Checkout\t4:Return");
    }

}
