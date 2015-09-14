package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MoviesTest {

    @Test
    public void shouldHaveAName() {
        Movies movies = new Movies("Titanic", 0, "bsb", 0);
        assertEquals("Titanic", movies.getMovieName());
    }

    @Test
    public void shouldHaveAYear() {
        Movies movies = new Movies("Titanic", 1990, "bsb", 0);
        assertEquals(1990, movies.getMovieYear());
    }

    @Test
    public void shouldHaveADirector() {
        Movies movies = new Movies("Titanic", 0, "James Cameron", 0);
        assertEquals("James Cameron", movies.getMovieDiector());
    }

    @Test
    public void shouldHaveAMovieRating() {
        Movies movies = new Movies("Titanic", 0, "bsb", 5);
        assertEquals(5, movies.getMovieRating());
    }

    @Test
    public void shouldBeEqualIfTheMovieNameIsSame() {
        Movies movies = new Movies("Titanic", 1990, "James Cameron", 5);
        assertEquals(movies, new Movies("Titanic", 1991, "James Camerone", 4));
    }

    @Test
    public void shouldBeUnEqualIfTheMovieNameIsDifferent() {
        Movies movies = new Movies("Titanic", 1990, "James Cameron", 5);
        assertNotEquals(movies, new Movies("Titanic1", 1990, "James Cameron", 5));
    }

}
