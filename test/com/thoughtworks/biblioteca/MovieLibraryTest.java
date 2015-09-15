package com.thoughtworks.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MovieLibraryTest {

    @Test
    public void shouldHaveAListOfAvailableMovies() {

        ArrayList<Movies> movies1 = new ArrayList<Movies>();
        movies1.add(new Movies("Titanic", 1990, "James Cameron", 5));
        MovieLibrary movieLibrary = new MovieLibrary(movies1);
        assertEquals(movies1,movieLibrary.getMovieLibrary());
    }

    @Test
    public void shouldReturnEqualIfTheMovieListsAreEqual() {
        ArrayList<Movies> movies = new ArrayList<Movies>();
        movies.add(new Movies("Titanic", 1990, "James Cameron", 5));
        movies.add(new Movies("Inception", 2010, "Christopher Nolan", 9));
        MovieLibrary movieLibrary1 = new MovieLibrary(movies);
        MovieLibrary movieLibrary2 = new MovieLibrary(movies);
        assertEquals(movieLibrary1,movieLibrary2);
    }

    @Test
    public void shouldReturnNotEqualIfTheMovieListsAreNotEqual() {
        ArrayList<Movies> movies = new ArrayList<Movies>();
        movies.add(new Movies("Titanic", 1990, "James Cameron", 5));
        movies.add(new Movies("Inception", 2010, "Christopher Nolan", 9));
        MovieLibrary movieLibrary1 = new MovieLibrary(movies);
        ArrayList<Movies> movies1 = new ArrayList<Movies>();
        movies1.add(new Movies("Titanic2", 1990, "James Cameron", 5));
        movies1.add(new Movies("Inception", 2010, "Christopher Nolan", 9));
        MovieLibrary movieLibrary2 = new MovieLibrary(movies1);
        assertNotEquals(movieLibrary1, movieLibrary2);
    }

    @Test
    public void shouldReturnEqualHashCodeIfTwoMoviesListsAreSame() {
        ArrayList<Movies> movies = new ArrayList<Movies>();
        movies.add(new Movies("Titanic", 1990, "James Cameron", 5));
        movies.add(new Movies("Inception", 2010, "Christopher Nolan", 9));
        MovieLibrary movieLibrary1 = new MovieLibrary(movies);
        ArrayList<Movies> movies1 = new ArrayList<Movies>();
        movies1.add(new Movies("Titanic", 1990, "James Cameron", 5));
        movies1.add(new Movies("Inception", 2010, "Christopher Nolan", 9));
        MovieLibrary movieLibrary2 = new MovieLibrary(movies1);
        assertEquals(movieLibrary1.hashCode(), movieLibrary2.hashCode());
    }

    @Test
    public void shouldReturnEqualHashCodeIfTwoMoviesListsAreDifferent() {
        ArrayList<Movies> movies = new ArrayList<Movies>();
        movies.add(new Movies("Titanic", 1990, "James Cameron", 5));
        movies.add(new Movies("Inception", 2010, "Christopher Nolan", 9));
        MovieLibrary movieLibrary1 = new MovieLibrary(movies);
        ArrayList<Movies> movies1 = new ArrayList<Movies>();
        movies1.add(new Movies("Titanicjk", 1990, "James Cameron", 5));
        movies1.add(new Movies("Inceptioon1", 2010, "Christopher Nolan", 9));
        MovieLibrary movieLibrary2 = new MovieLibrary(movies1);
        assertNotEquals(movieLibrary1.hashCode(), movieLibrary2.hashCode());
    }

    @Test
    public void shouldReturnAValidMovieListAfterCheckout() {
        ArrayList<Movies> movies = new ArrayList<Movies>();
        movies.add(new Movies("Titanic", 1990, "James Cameron", 5));
        MovieLibrary movieLibrary1 = new MovieLibrary(movies);
        movies.add(new Movies("Inception", 2010, "Christopher Nolan", 9));
        MovieLibrary movieLibrary2 = new MovieLibrary(movies);
        movieLibrary1.checkout("Inception");
        assertEquals(movieLibrary1, movieLibrary2);
    }

    @Test
    public void shouldValidateASuccessfulReturn()
    {
        ArrayList<Movies> movies = new ArrayList<Movies>();
        movies.add(new Movies("Titanic", 1990, "James Cameron", 5));
        movies.add(new Movies("Inception", 2010, "Christopher Nolan", 9));
        MovieLibrary movieLibrary1 = new MovieLibrary(movies);
        MovieLibrary movieLibrary2 = new MovieLibrary(movies);
        movieLibrary1.checkout("Inception");
        movieLibrary1.returnMovie("Inception");
        assertEquals(movieLibrary1, movieLibrary2);

    }

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setOutputStream() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldReturnValidMovie() {
        ArrayList<Movies> movies = new ArrayList<Movies>();
        movies.add(new Movies("Titanic", 1990, "James Cameron", 5));
        MovieLibrary movieLibrary = new MovieLibrary(movies);
        movieLibrary.displayContents();
        assertEquals(String.format("%-34s %-34d %-34s %-34d\n", "Titanic", 1990, "James Cameron", 5), outContent.toString());
    }
    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
    }

}
