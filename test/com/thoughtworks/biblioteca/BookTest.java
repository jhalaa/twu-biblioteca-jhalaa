package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BookTest {

    @Test
    public void shouldReturnTheValidBookDetails() {
        User user = new User("123", "123");
        Book book = new Book("Harry Potter", "JK Rowling", 1993, user);
        assertEquals(book.toString(), String.format("%-34s %-34s %-34d", "Harry Potter", "JK Rowling", 1993));
    }

    @Test
    public void shouldReturnEqualIfTheBookNameISEqual() {
        User user = new User("123", "123");
        Book book = new Book("Harry Potter", "JK Rowling", 1993, user);
        assertEquals(book, new Book("Harry Potter", "JK Rowling", 1993, user));
    }

    @Test
    public void shouldReturnEqualHasCodeIfTwoBooksAreSame() {
        User user = new User("123", "123");
        Book book1 = new Book("Harry Potter", "JK Rowling", 1994, user);
        Book book2 = new Book("Harry Potter", "JK Rowling", 1994, user);
        assertEquals(book1.hashCode(), book2.hashCode());
    }

    @Test
    public void shouldReturnDifferentHashCodeIfTwoBooksAreDifferent() {
        User user = new User("123", "123");
        Book book1 = new Book("Harry Potter", "JK Rowling", 1994, user);
        Book book2 = new Book("Harry Potter", "JK Rowling1", 1994, user);
        assertNotEquals(book1.hashCode(), book2.hashCode());
    }
}
