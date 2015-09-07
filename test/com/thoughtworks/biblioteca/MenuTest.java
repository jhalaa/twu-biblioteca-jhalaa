package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MenuTest {

    @Test
    public void shouldDisplayTheListOfBooksIfOptionIsOne() {
        Menu menu = new Menu();
        assertEquals(menu.displayMenuOption(),"1:List of books\t2:Exit\tCheckout");
    }
}
