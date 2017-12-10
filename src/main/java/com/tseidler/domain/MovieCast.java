package com.tseidler.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MovieCast {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Actor actor;

    public MovieCast(Movie movie, Actor actor) {
        this.movie = movie;
        this.actor = actor;
    }

    public MovieCast() {
    }

    @Override
    public String toString() {
        return String.format("MovieCast{ id: %d, movie: %s, actor: %s",id, movie.toString(), actor.toString());
    }
}
