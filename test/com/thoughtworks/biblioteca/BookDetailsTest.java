package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookDetailsTest {

    @Test
    public void shouldReturnTheValidBookDetails() {
        BookDetails bookDetails = new BookDetails("Harry Potter","JK Rowling",1993);
        assertEquals(bookDetails.toString(), "Harry Potter JK Rowling 1993");
    }
}
