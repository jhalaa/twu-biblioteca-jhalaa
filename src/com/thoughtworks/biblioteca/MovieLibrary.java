package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class MovieLibrary {
    private ArrayList<Movies> movies;
    public MovieLibrary(ArrayList<Movies> movies) {
        this.movies = movies;
    }

    public MovieLibrary getMovieLibrary() {
        return this;
    }
}
