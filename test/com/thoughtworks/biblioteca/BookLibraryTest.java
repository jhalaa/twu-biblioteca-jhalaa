package com.thoughtworks.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BookLibraryTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setOutputStream() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldReturnValidBook() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Harry Potter", "JK Rowling", 1993));
        BookLibrary bookLibrary = new BookLibrary(books);
        bookLibrary.displayContents();
        assertEquals(String.format("%-34s %-34s %-34d\n", "Harry Potter", "JK Rowling", 1993), outContent.toString());
    }

    @Test
    public void shouldReturnValidBooks() {
        ArrayList<Book> books = new ArrayList<Book>();
        BookLibrary bookLibrary = new BookLibrary(books);
        books.add(new Book("Harry Potter", "JK Rowling", 1993));
        books.add(new Book("Da Vinci Code", "Dan Brown", 2007));
        bookLibrary.displayContents();
        assertEquals(String.format("%-34s %-34s %-34d\n%-34s %-34s %-34d\n", "Harry Potter", "JK Rowling", 1993, "Da Vinci Code", "Dan Brown", 2007), outContent.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
    }

    @Test
    public void shouldReturnEqualIfTheBookListsAreEqual() {
        ArrayList<Book> books = new ArrayList<Book>();
        BookLibrary bookLibrary1 = new BookLibrary(books);
        books.add(new Book("Harry Potter", "JK Rowling", 1993));
        books.add(new Book("Da Vinci Code", "Dan Brown", 2007));
        BookLibrary bookLibrary2 = new BookLibrary(books);
        books.add(new Book("Harry Potter", "JK Rowling", 1993));
        books.add(new Book("Da Vinci Code", "Dan Brown", 2007));
        assertEquals(bookLibrary1, bookLibrary2);
    }

    @Test
    public void shouldReturnNotEqualIfTheBookListsAreUnequal() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Harry Potter", "JK Rowling", 1995));
        books.add(new Book("Da Vinci Code", "Dan Brown2", 2007));
        BookLibrary bookLibrary1 = new BookLibrary(books);
        ArrayList<Book> books1 = new ArrayList<Book>();
        books1.add(new Book("Harry Potter1", "JK Rowling", 1995));
        books1.add(new Book("Da Vinci", "Dan Brown", 2007));
        BookLibrary bookLibrary2 = new BookLibrary(books1);
        assertNotEquals(bookLibrary1, bookLibrary2);
    }

    @Test
    public void shouldReturnEqualHashCodeIfTwoBookListsAreSame() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Harry Potter", "JK Rowling", 1995));
        books.add(new Book("Da Vinci Code", "Dan Brown", 2007));
        BookLibrary bookLibrary1 = new BookLibrary(books);
        ArrayList<Book> books1 = new ArrayList<Book>();
        books1.add(new Book("Harry Potter", "JK Rowling", 1995));
        books1.add(new Book("Da Vinci Code", "Dan Brown", 2007));
        BookLibrary bookLibrary2 = new BookLibrary(books1);
        assertEquals(bookLibrary1.hashCode(), bookLibrary2.hashCode());
    }

    @Test
    public void shouldNotReturnEqualHashCodeIfTwoBookListsAreDifferent() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Harry Potter", "JK Rowling", 1995));
        books.add(new Book("Da Vinci Code", "Dan Brown", 2007));
        BookLibrary bookLibrary1 = new BookLibrary(books);
        ArrayList<Book> books1 = new ArrayList<Book>();
        books1.add(new Book("Harry Potter1", "JK Rowling", 1995));
        books1.add(new Book("Da Vinci Code", "Dan Brown", 2007));
        BookLibrary bookLibrary2 = new BookLibrary(books1);
        assertNotEquals(bookLibrary1.hashCode(), bookLibrary2.hashCode());
    }

    @Test
    public void shouldReturnAValidBookAfterCheckout() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Harry Potter", "JK Rowling", 1995));
        BookLibrary bookLibrary1 = new BookLibrary(books);
        books.add(new Book("Da Vinci Code", "Dan Brown", 2007));
        BookLibrary bookLibrary2 = new BookLibrary(books);
        bookLibrary2.checkOutBook("Da Vinci Code");
        assertEquals(bookLibrary1, bookLibrary2);
    }

    @Test
    public void shouldValidateASuccessfulReturn()
    {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Harry Potter", "JK Rowling", 1995));
        books.add(new Book("Da Vinci Code", "Dan Brown", 2007));
        BookLibrary bookLibrary1 = new BookLibrary(books);
        BookLibrary bookLibrary2 = new BookLibrary(books);
        bookLibrary2.checkOutBook("Harry Potter");
        bookLibrary2.returnBook("Harry Potter");
        assertEquals(bookLibrary1, bookLibrary2);

    }

}
