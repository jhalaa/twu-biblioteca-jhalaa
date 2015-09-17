package com.thoughtworks.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class DispatcherTest {


    @Test
    public void shouldDisplayBookLibraryWhenOptionIsOne() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("1".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setIn(inputStream);
        System.setOut(printStream);
        Scanner scanner = new Scanner(inputStream);
        ArrayList<Book> books = new ArrayList<Book>();
        User user = new User("0", "0","0","0","0");
        books.add(new Book("Harry Potter", "JK Rowling", 1993,user));
        BookLibrary bookLibrary = new BookLibrary(books);
        ArrayList<Movies> movies = new ArrayList<Movies>();
        movies.add(new Movies("Titanic", 1990, "James Cameron", 5));
        MovieLibrary movieLibrary = new MovieLibrary(movies);
        ConfigurationOfUsers configurationOfUsers = new ConfigurationOfUsers();
        Login login = new Login(configurationOfUsers.returnUserList(), scanner);
        Validator validator = new Validator(login);
        Dispatcher dispatcher = new Dispatcher(movieLibrary, bookLibrary, scanner, validator,user);
        dispatcher.run();
        assertEquals(String.format("%-34s %-34s %-34d\n", "Harry Potter", "JK Rowling", 1993), outputStream.toString());
    }

    @Test
    public void shouldDisplayMovieLibraryWhenOptionIsSix() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("6".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setIn(inputStream);
        System.setOut(printStream);
        Scanner scanner = new Scanner(inputStream);
        ArrayList<Book> books = new ArrayList<Book>();
        User user = new User("0", "0","0","0","0");
        books.add(new Book("Harry Potter", "JK Rowling", 1993,user));
        BookLibrary bookLibrary = new BookLibrary(books);
        ArrayList<Movies> movies = new ArrayList<Movies>();
        movies.add(new Movies("Titanic", 1990, "James Cameron", 5));
        MovieLibrary movieLibrary = new MovieLibrary(movies);
        Dispatcher dispatcher = new Dispatcher(movieLibrary, bookLibrary, scanner, null,user);
        dispatcher.run();
        assertEquals(String.format("%-34s %-34d %-34s %-34d\n", "Titanic", 1990, "James Cameron", 5), outputStream.toString());
    }

    @Test
    public void shouldCheckoutMovieWhenOptionIsFive() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("5\nTitanic".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setIn(inputStream);
        System.setOut(printStream);
        Scanner scanner = new Scanner(inputStream);
        ArrayList<Book> books = new ArrayList<Book>();
        User user = new User("0", "0","0","0","0");
        books.add(new Book("Harry Potter", "JK Rowling", 1993,user));
        BookLibrary bookLibrary = new BookLibrary(books);
        ArrayList<Movies> movies = new ArrayList<Movies>();
        movies.add(new Movies("Titanic", 1990, "James Cameron", 5));
        movies.add(new Movies("Titanic11", 1990, "James Cameron", 5));
        MovieLibrary movieLibrary = new MovieLibrary(movies);
        Dispatcher dispatcher = new Dispatcher(movieLibrary, bookLibrary, scanner, null,user);
        dispatcher.run();
        assertEquals("Thank you! Enjoy the movie\n", outputStream.toString());
    }

    @Test
    public void shouldSuccesfullyCheckoutBookWhenBookIsAvailableAndOptionIsThree() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("3\n123-4567\njhalaa\nHarry Potter\n".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setIn(inputStream);
        System.setOut(printStream);
        Scanner scanner = new Scanner(inputStream);
        ArrayList<Book> books = new ArrayList<Book>();
        User user = new User("0", "0","0","0","0");
        books.add(new Book("Harry Potter", "JK Rowling", 1993,user));
        books.add(new Book("Da Vinci Code", "Dan Brown", 2007,user));
        BookLibrary bookLibrary = new BookLibrary(books);
        ArrayList<Movies> movies = new ArrayList<Movies>();
        movies.add(new Movies("Titanic", 1990, "James Cameron", 5));
        MovieLibrary movieLibrary = new MovieLibrary(movies);
        ConfigurationOfUsers configurationOfUsers = new ConfigurationOfUsers();
        Login login = new Login(configurationOfUsers.returnUserList(), scanner);
        Validator validator = new Validator(login);
        Dispatcher dispatcher = new Dispatcher(movieLibrary, bookLibrary, scanner, validator, user);
        dispatcher.run();
        assertEquals("Enter login credentials\nEnter book name\nThank you! Enjoy the book\n", outputStream.toString());
    }

    @Test
    public void shouldReturnBookNotValidMessageWhenBookIsNotAvailableAndOptionIsThree() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("3\n123-4567\njhalaa\nHarry\n".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setIn(inputStream);
        System.setOut(printStream);
        Scanner scanner = new Scanner(inputStream);
        ArrayList<Book> books = new ArrayList<Book>();
        User user = new User("0", "0","0","0","0");
        books.add(new Book("Harry Potter", "JK Rowling", 1993,user));
        books.add(new Book("Da Vinci Code", "Dan Brown", 2007, user));
        BookLibrary bookLibrary = new BookLibrary(books);
        ArrayList<Movies> movies = new ArrayList<Movies>();
        movies.add(new Movies("Titanic", 1990, "James Cameron", 5));
        MovieLibrary movieLibrary = new MovieLibrary(movies);
        ConfigurationOfUsers configurationOfUsers = new ConfigurationOfUsers();
        Login login = new Login(configurationOfUsers.returnUserList(), scanner);
        Validator validator = new Validator(login);
        Dispatcher dispatcher = new Dispatcher(movieLibrary, bookLibrary, scanner, validator,user);
        dispatcher.run();
        assertEquals("Enter login credentials\nEnter book name\nThat book is not available\n", outputStream.toString());
    }

    @Test
    public void shouldReturnMessageWhenValidBookIsReturnedAndOptionIsFour() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("4\n123-4567\njhalaa\nHarry Potter\n".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setIn(inputStream);
        System.setOut(printStream);
        Scanner scanner = new Scanner(inputStream);
        ArrayList<Book> books = new ArrayList<Book>();
        User user = new User("0", "0","0","0","0");
        books.add(new Book("Harry Potter", "JK Rowling", 1993,user));
        books.add(new Book("Da Vinci Code", "Dan Brown", 2007,user));
        BookLibrary bookLibrary = new BookLibrary(books);
        bookLibrary.checkOutBook("Harry Potter",user);
        ArrayList<Movies> movies = new ArrayList<Movies>();
        movies.add(new Movies("Titanic", 1990, "James Cameron", 5));
        MovieLibrary movieLibrary = new MovieLibrary(movies);
        ConfigurationOfUsers configurationOfUsers = new ConfigurationOfUsers();
        Login login = new Login(configurationOfUsers.returnUserList(), scanner);
        Validator validator = new Validator(login);
        Dispatcher dispatcher = new Dispatcher(movieLibrary, bookLibrary, scanner, validator,user);
        dispatcher.run();
        assertEquals("Thank you! Enjoy the book\nEnter login credentials\nenter book name\nThat is not a valid book to return.\n", outputStream.toString());
    }

    @Test
    public void shouldReturnMessageWhenInValidBookIsReturnedAndOptionIsFour() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("4\n123-4567\njhalaa\nHarry\n".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setIn(inputStream);
        System.setOut(printStream);
        Scanner scanner = new Scanner(inputStream);
        ArrayList<Book> books = new ArrayList<Book>();
        User user = new User("0", "0","0","0","0");
        books.add(new Book("Harry Potter", "JK Rowling", 1993,user));
        books.add(new Book("Da Vinci Code", "Dan Brown", 2007, user));
        BookLibrary bookLibrary = new BookLibrary(books);
        bookLibrary.checkOutBook("Harry Potter",user);
        ArrayList<Movies> movies = new ArrayList<Movies>();
        movies.add(new Movies("Titanic", 1990, "James Cameron", 5));
        MovieLibrary movieLibrary = new MovieLibrary(movies);
        ConfigurationOfUsers configurationOfUsers = new ConfigurationOfUsers();
        Login login = new Login(configurationOfUsers.returnUserList(), scanner);
        Validator validator = new Validator(login);
        Dispatcher dispatcher = new Dispatcher(movieLibrary, bookLibrary, scanner, validator,user);
        dispatcher.run();
        assertEquals("Thank you! Enjoy the book\nEnter login credentials\nenter book name\nThat is not a valid book to return.\n", outputStream.toString());
    }

    @Test
    public void shouldLogoutWhenOptionSelectedIsSeven() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("7".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setIn(inputStream);
        System.setOut(printStream);
        Scanner scanner = new Scanner(inputStream);
        ArrayList<Book> books = new ArrayList<Book>();
        User user = new User("0", "0","0","0","0");
        books.add(new Book("Harry Potter", "JK Rowling", 1993,user));
        books.add(new Book("Da Vinci Code", "Dan Brown", 2007, user));
        BookLibrary bookLibrary = new BookLibrary(books);
        ArrayList<Movies> movies = new ArrayList<Movies>();
        movies.add(new Movies("Titanic", 1990, "James Cameron", 5));
        MovieLibrary movieLibrary = new MovieLibrary(movies);
        ConfigurationOfUsers configurationOfUsers = new ConfigurationOfUsers();
        Login login = new Login(configurationOfUsers.returnUserList(), scanner);
        Validator validator = new Validator(login);
        Dispatcher dispatcher = new Dispatcher(movieLibrary, bookLibrary, scanner, validator,user);
        dispatcher.run();
        assertEquals(dispatcher.getUser(), user);
    }

    @Test
    public void shouldDisplayUserDetailsWhenOptionIsNine() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("9".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setIn(inputStream);
        System.setOut(printStream);
        Scanner scanner = new Scanner(inputStream);
        ArrayList<Book> books = new ArrayList<Book>();
        User user = mock(User.class);
        books.add(new Book("Harry Potter", "JK Rowling", 1993,user));
        BookLibrary bookLibrary = new BookLibrary(books);
        ArrayList<Movies> movies = new ArrayList<Movies>();
        movies.add(new Movies("Titanic", 1990, "James Cameron", 5));
        MovieLibrary movieLibrary = new MovieLibrary(movies);
        ConfigurationOfUsers configurationOfUsers = new ConfigurationOfUsers();
        Login login = new Login(configurationOfUsers.returnUserList(), scanner);
        Validator validator = new Validator(login);
        Dispatcher dispatcher = new Dispatcher(movieLibrary, bookLibrary, scanner, validator,user);
        dispatcher.run();
        verify(user , times(1)).getMyDetails();
    }

    @Test
    public void shouldReturnMessageWhenInvalidMenuOptionIsSelected() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("10".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setIn(inputStream);
        System.setOut(printStream);
        Scanner scanner = new Scanner(inputStream);
        ArrayList<Book> books = new ArrayList<Book>();
        User user = new User("0", "0","0","0","0");
        books.add(new Book("Harry Potter", "JK Rowling", 1993,user));
        books.add(new Book("Da Vinci Code", "Dan Brown", 2007,user));
        BookLibrary bookLibrary = new BookLibrary(books);
        ArrayList<Movies> movies = new ArrayList<Movies>();
        movies.add(new Movies("Titanic", 1990, "James Cameron", 5));
        MovieLibrary movieLibrary = new MovieLibrary(movies);
        ConfigurationOfUsers configurationOfUsers = new ConfigurationOfUsers();
        Login login = new Login(configurationOfUsers.returnUserList(), scanner);
        Validator validator = new Validator(login);
        Dispatcher dispatcher = new Dispatcher(movieLibrary, bookLibrary, scanner, validator,user);
        dispatcher.run();
        assertEquals("Invalid menu option\n", outputStream.toString());
    }


    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldExitWhenOptionSelectedIsTwo() {
        exit.expectSystemExit();
        System.exit(0);
    }

}
