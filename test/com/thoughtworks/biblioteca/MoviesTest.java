package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoviesTest {

    @Test
    public void shouldHaveAName() {
        Movies movies = new Movies();
        assertEquals("Titanic",movies.getMovieName());
    }

    @Test
    public void shouldHaveAYear() {
        Movies movies = new Movies();
        assertEquals(1990,movies.getMovieYear());
    }

    @Test
    public void shouldHaveADirector() {
        Movies movies = new Movies();
        assertEquals("James Cameron",movies.getMovieDiector());
    }

}
