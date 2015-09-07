package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BookTest {

    @Test
    public void shouldReturnTheValidBookDetails() {
        Book book = new Book("Harry Potter", "JK Rowling", 1993);
        assertEquals(book.toString(), "Harry Potter JK Rowling 1993");
    }
    @Test
    public void shouldReturnEqualIfTheBookNameISEqual() {
        Book book = new Book("Harry Potter", "JK Rowling", 1993);
        assertEquals(book , new Book("Harry Potter", "JK Rowling", 1993));
    }
    @Test
    public void shouldReturnEqualIfTheBookNameAndAuthorISEqual() {
        Book book = new Book("Harry Potter", "JK Rowling", 1993);
        assertNotEquals(book, new Book("Harry Potter", "JK Rowling1", 1993));
    }
}
