package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void shouldReturnTheValidBookDetails() {
        Book book = new Book("Harry Potter", "JK Rowling", 1993);
        assertEquals(book.toString(), "Harry Potter JK Rowling 1993");
    }
}
