package com.tseidler.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Film")
public class Movie {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;

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
        return String.format("id: %d; title: %s", id, title);
    }

}
