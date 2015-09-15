package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class MovieLibrary {
    private ArrayList<Movies> AvailableMovies;
    public MovieLibrary(ArrayList<Movies> AvailableMovies) {
        this.AvailableMovies = AvailableMovies;
    }

    public ArrayList<Movies> getMovieLibrary() {
        return AvailableMovies;
    }
}
