package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MoviesTest {

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

    @Test
    public void shouldReturnEqualHasCodeIfTwoBooksAreSame() {
        Movies movies1 = new Movies("Titanic", 1990, "James Cameron", 5);
        Movies movies2 = new Movies("Titanic", 1990, "James Cameron", 5);
        assertEquals(movies1.hashCode(), movies2.hashCode());
    }

    @Test
    public void shouldReturnUnequalHasCodeIfTwoBooksAreDifferent() {
        Movies movies1 = new Movies("Titani1", 1990, "James Cameron", 5);
        Movies movies2 = new Movies("Titanic", 1990, "James Cameron", 5);
        assertNotEquals(movies1.hashCode(), movies2.hashCode());
    }

    @Test
    public void shouldReturnTheValidMovieDetails() {
        Movies movies1 = new Movies("Titanic", 1990, "James Cameron", 5);
        assertEquals(movies1.toString(), String.format("%-34s %-34d %-34s %-34d", "Titanic",1990, "James Cameron", 5));
    }

}
