package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BookTest {

    @Test
    public void shouldReturnTheValidBookDetails() {
        Book book = new Book("Harry Potter", "JK Rowling", 1993);
        assertEquals(book.toString(), String.format("%-34s %-34s %-34d","Harry Potter","JK Rowling",1993));
    }

    @Test
    public void shouldReturnEqualIfTheBookNameISEqual() {
        Book book = new Book("Harry Potter", "JK Rowling", 1993);
        assertEquals(book, new Book("Harry Potter", "JK Rowling", 1993));
    }

    @Test
    public void shouldReturnEqualHasCodeIfTwoBooksAreSame() {
        Book book1 = new Book("Harry Potter", "JK Rowling", 1994);
        Book book2 = new Book("Harry Potter", "JK Rowling", 1994);
        assertEquals(book1.hashCode(), book2.hashCode());
    }

    @Test
    public void shouldReturnDifferentHashCodeIfTwoBooksAreDifferent() {
        Book book1 = new Book("Harry Potter", "JK Rowling", 1994);
        Book book2 = new Book("Harry Potter", "JK Rowling1", 1994);
        assertNotEquals(book1.hashCode(), book2.hashCode());
    }
}
