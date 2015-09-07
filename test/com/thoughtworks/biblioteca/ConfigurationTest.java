package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ConfigurationTest {

    @Test
    public void shouldReturnAValidListOFBooks() {
        Configuration configuration = new Configuration();
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Harry Potter", "JK Rowling", 1993));
        books.add(new Book("Da Vinci Code", "Dan Brown", 2007));
        Library library = new Library(books);
        assertEquals(configuration.start(), library);
    }
}
