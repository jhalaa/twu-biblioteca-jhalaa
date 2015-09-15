package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ConfigurationTest {

    @Test
    public void shouldReturnAValidListOFBooks() {
        Configuration configuration = new Configuration();
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Harry Potter", "JK Rowling", 1993));
        books.add(new Book("Da Vinci Code", "Dan Brown", 2007));
        books.add(new Book("Atlas shrugged", "Ayn Rand", 1990));
        books.add(new Book("Emma", "Jane Austen", 1890));
        books.add(new Book("Hitchicker's guide to galaxy", "Douglas Adams", 1989));
        BookLibrary bookLibrary = new BookLibrary(books);
        assertEquals(configuration.start(), bookLibrary);
    }
}
