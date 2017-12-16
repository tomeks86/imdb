package com.tseidler.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "Film")
public class Movie {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    @OneToOne
    private MovieDetail movieDetail;

    public MovieDetail getMovieDetail() {
        return movieDetail;
    }

    public void setMovieDetail(MovieDetail movieDetail) {
        this.movieDetail = movieDetail;
    }

    public Movie(String title) {
        this.title = title;
    }

    public Movie() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        if (movieDetail != null) return String.format("id: %d; title: %s, description:\n%s", id, title, movieDetail.toString());
        else return String.format("id: %d; title: %s", id, title);
    }

}
