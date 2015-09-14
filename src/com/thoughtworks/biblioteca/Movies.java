package com.thoughtworks.biblioteca;

public class Movies {
    private String movieName = "Titanic";
    private int movieYear = 1990;
    private String movieDirector = "James Cameron";
    private int movieRating = 5;

    public Movies(String movieName, int movieYear, String movieDirector, int movieRating) {
        this.movieName = movieName;
        this.movieYear = movieYear;
        this.movieDirector = movieDirector;
        this.movieRating = movieRating;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getMovieYear() {
        return movieYear;
    }

    public String getMovieDiector() {
        return movieDirector;
    }

    public int getMovieRating() {
        return movieRating;
    }

    @Override
    public boolean equals(Object object) {
        Movies movies = (Movies)object;
        if(this.movieName.equals(movies.movieName))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 7 * hash + this.movieName.hashCode();
        hash = 7 * hash + this.movieDirector.hashCode();
        return hash+movieYear;
    }
}
