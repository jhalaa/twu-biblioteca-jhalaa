package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ConfigurationOfMoviesTest {

    @Test
    public void shouldReturnAValidListOfMovies() {
        ConfigurationOfMovies configurationOfMovies = new ConfigurationOfMovies();
        ArrayList<Movies> movies = new ArrayList<Movies>();
        movies.add(new Movies("Titanic", 1997, "James Cameron", 9));
        movies.add(new Movies("Inception",2010,"Christopher Nolan",9));
        movies.add(new Movies("The Great Gatsby",2013,"Baz Luhrmann", 10));
        movies.add(new Movies("Catch Me If You Can", 2002, "Stephan Speilberg", 8));
        MovieLibrary movieLibrary = new MovieLibrary(movies);
        assertEquals(configurationOfMovies.start(), movieLibrary);
    }
}
