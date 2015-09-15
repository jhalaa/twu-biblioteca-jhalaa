package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

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

}
