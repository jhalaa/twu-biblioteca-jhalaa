package com.thoughtworks.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class LibraryTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setOutputStream() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldReturnValidBook() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Harry Potter", "JK Rowling", 1993));
        Library library = new Library(books);
        library.displayContents();
        assertEquals(String.format("%-34s %-34s %-34d\n", "Harry Potter", "JK Rowling", 1993), outContent.toString());
    }

    @Test
    public void shouldReturnValidBooks() {
        ArrayList<Book> books = new ArrayList<Book>();
        Library library = new Library(books);
        books.add(new Book("Harry Potter", "JK Rowling", 1993));
        books.add(new Book("Da Vinci Code", "Dan Brown", 2007));
        library.displayContents();
        assertEquals(String.format("%-34s %-34s %-34d\n%-34s %-34s %-34d\n", "Harry Potter", "JK Rowling", 1993, "Da Vinci Code", "Dan Brown", 2007), outContent.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
    }

    @Test
    public void shouldReturnEqualIfTheBookListsAreEqual() {
        ArrayList<Book> books = new ArrayList<Book>();
        Library library1 = new Library(books);
        books.add(new Book("Harry Potter", "JK Rowling", 1993));
        books.add(new Book("Da Vinci Code", "Dan Brown", 2007));
        Library library2 = new Library(books);
        books.add(new Book("Harry Potter", "JK Rowling", 1993));
        books.add(new Book("Da Vinci Code", "Dan Brown", 2007));
        assertEquals(library1, library2);
    }

    @Test
    public void shouldReturnNotEqualIfTheBookListsAreUnequal() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Harry Potter", "JK Rowling", 1995));
        books.add(new Book("Da Vinci Code", "Dan Brown2", 2007));
        Library library1 = new Library(books);
        ArrayList<Book> books1 = new ArrayList<Book>();
        books1.add(new Book("Harry Potter1", "JK Rowling", 1995));
        books1.add(new Book("Da Vinci", "Dan Brown", 2007));
        Library library2 = new Library(books1);
        assertNotEquals(library1, library2);
    }

    @Test
    public void shouldReturnEqualHashCodeIfTwoBookListsAreSame() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Harry Potter", "JK Rowling", 1995));
        books.add(new Book("Da Vinci Code", "Dan Brown", 2007));
        Library library1 = new Library(books);
        ArrayList<Book> books1 = new ArrayList<Book>();
        books1.add(new Book("Harry Potter", "JK Rowling", 1995));
        books1.add(new Book("Da Vinci Code", "Dan Brown", 2007));
        Library library2 = new Library(books1);
        assertEquals(library1.hashCode(), library2.hashCode());
    }

    @Test
    public void shouldNotReturnEqualHashCodeIfTwoBookListsAreDifferent() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Harry Potter", "JK Rowling", 1995));
        books.add(new Book("Da Vinci Code", "Dan Brown", 2007));
        Library library1 = new Library(books);
        ArrayList<Book> books1 = new ArrayList<Book>();
        books1.add(new Book("Harry Potter1", "JK Rowling", 1995));
        books1.add(new Book("Da Vinci Code", "Dan Brown", 2007));
        Library library2 = new Library(books1);
        assertNotEquals(library1.hashCode(), library2.hashCode());
    }

    @Test
    public void shouldReturnAValidBookAfterCheckout() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Harry Potter", "JK Rowling", 1995));
        Library library1 = new Library(books);
        books.add(new Book("Da Vinci Code", "Dan Brown", 2007));
        Library library2 = new Library(books);
        library2.checkOutBook("Da Vinci Code");
        assertEquals(library1, library2);
    }

    @Test
    public void shouldValidateASuccessfulReturn()
    {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Harry Potter", "JK Rowling", 1995));
        books.add(new Book("Da Vinci Code", "Dan Brown", 2007));
        Library library1 = new Library(books);
        Library library2 = new Library(books);
        library2.checkOutBook("Harry Potter");
        library2.returnBook("Harry Potter");
        assertEquals(library1,library2);

    }

}
