package com.example.netflix;

public class Movie {
    private String movieTitle;
    private String poster_path;
    private String movieRating;
    private String backdrop_path;
    private String movie_detail;

    public Movie(){}

    public Movie(String movieTitle, String poster_path, String movieRating, String backdrop_path, String movie_detail) {
        this.movieTitle = movieTitle;
        this.poster_path = poster_path;
        this.movieRating = movieRating;
        this.backdrop_path = backdrop_path;
        this.movie_detail = movie_detail;
    }


    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getMovie_detail() {
        return movie_detail;
    }

    public void setMovie_detail(String movie_detail) {
        this.movie_detail = movie_detail;
    }
}
