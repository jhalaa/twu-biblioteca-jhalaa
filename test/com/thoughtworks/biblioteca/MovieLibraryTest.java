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


}
