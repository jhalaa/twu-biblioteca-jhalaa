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
        verify(printer).printMessage("\n1:List of books\t2:Exit\t3:Checkout Books\t4:Return\t5:Checkout Movies\t6:List of movies\t7:logout");
    }

}
