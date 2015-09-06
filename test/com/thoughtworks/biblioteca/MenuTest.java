package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MenuTest {

    @Test
    public void shouldDisplayTheListOfBooksIfOptionIsOne() {
        Menu menu = new Menu("1");
        assertTrue(menu.returnsMenuOptionSelected());
    }

    @Test
    public void shouldDisplayInvalidMenuOptionIfOptionIsTrue() {
        Menu menu = new Menu("2");
        assertFalse(menu.returnsMenuOptionSelected());
    }
}
