package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.mockito.Mockito.mock;

public class DescisionMakerTest {

    ByteArrayInputStream inputStream = new ByteArrayInputStream("1".getBytes());

    @Test
    public void shouldDisplayLibraryWhenOptionIsOne() {
        System.setIn(inputStream);
        Scanner scanner = new Scanner(inputStream);
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Harry Potter", "JK Rowling", 1993));
        Library library = new Library(books);
        DecsicionMaker decsicionMaker = new DecsicionMaker(library,scanner);
        decsicionMaker.start();
    }

}
