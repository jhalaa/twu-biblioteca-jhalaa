package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoviesTest {

    @Test
    public void shouldHaveAName()
    {
        Movies movies = new Movies();
        assertEquals("Titanic",movies.getMovieName());
    }


}
