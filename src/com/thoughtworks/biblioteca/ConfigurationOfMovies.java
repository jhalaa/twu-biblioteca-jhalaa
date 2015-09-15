package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class ConfigurationOfMovies {

        private ArrayList<Movies> movies;
        private MovieLibrary movieLibrary;

        public MovieLibrary start() {
            movies = new ArrayList<Movies>();
            movies.add(new Movies("Titanic", 1997, "James Cameron", 9));
            movies.add(new Movies("Inception",2010,"Christopher Nolan",9));
            movies.add(new Movies("The Great Gatsby",2013,"Baz Luhrmann", 10));
            movies.add(new Movies("Catch Me If You Can", 2002, "Stephan Speilberg", 8));
            movieLibrary = new MovieLibrary(movies);
            return movieLibrary;
        }
}
