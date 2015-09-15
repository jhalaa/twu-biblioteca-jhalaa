package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class MovieLibrary {
    private ArrayList<Movies> availableMovies;

    public MovieLibrary(ArrayList<Movies> availableMovies) {
        this.availableMovies = availableMovies;
    }

    public ArrayList<Movies> getMovieLibrary() {
        return availableMovies;
    }

    @Override
    public boolean equals(Object object) {
        MovieLibrary that = (MovieLibrary) object;
        for (int i = 0; i < availableMovies.size(); i++) {
            if (!(this.availableMovies.get(i).equals(that.availableMovies.get(i))))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 7 * hash + availableMovies.get(0).hashCode();
        return hash;
    }
}
