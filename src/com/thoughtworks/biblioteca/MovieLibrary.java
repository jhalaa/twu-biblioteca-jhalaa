package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class MovieLibrary {
    private static final int UNKNOWN_YEAR = 0;
    private static final int UNKNOWN_RATING = 0 ;
    private static final String UNKNOWN_DIRECTOR = null;
    private Printer printer = new Printer(System.out);
    private ArrayList<Movies> availableMovies = new ArrayList<Movies>();
    private ArrayList<Movies> checkedOutMovies = new ArrayList<Movies>();

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

    public void checkout(String name) {
        CheckoutMessage checkoutMessage;
        Movies movies = new Movies(name, UNKNOWN_YEAR, UNKNOWN_DIRECTOR, UNKNOWN_RATING);
        if (availableMovies.contains(movies)) {
            int index = availableMovies.indexOf(movies);
            checkedOutMovies.add(availableMovies.get(index));
            availableMovies.remove(movies);
            checkoutMessage = new CheckoutMessage(printer);
            checkoutMessage.printSuccessfulMessage();
        } else {
            checkoutMessage = new CheckoutMessage(printer);
            checkoutMessage.printUnsuccessfulMessage();
        }

    }
}
