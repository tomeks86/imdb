package com.tseidler.service;

import com.tseidler.domain.Actor;
import com.tseidler.domain.Movie;
import com.tseidler.domain.MovieCast;
import com.tseidler.repository.MovieCastRepository;
import com.tseidler.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MovieCastService {
    @Autowired
    private MovieCastRepository movieCastRepository;
    @Autowired
    private MovieRepository movieRepository;

    public void addMovieCast(MovieCast movieCast) {
        movieCastRepository.save(movieCast);
    }

    public List<MovieCast> getCasts() {
        List<MovieCast> result = new ArrayList<>();
        movieCastRepository.findAll().forEach(movieCast -> result.add(movieCast));
        return result;
    }

    public List<Movie> getMovieCastsByActor_Lastname(String lastName) {
        List<Movie> movies = new ArrayList<>();
        movieCastRepository.findMovieCastsByActor_Lastname(lastName).forEach(movieCast -> movies.add(movieCast.getMovie()));
        return movies;
    }

    public List<Movie> getMovieCastsByActor_FirstnameAndActor_Lastname(String firstName, String lastName) {
        List<Movie> movies = new ArrayList<>();
        movieCastRepository.findMovieCastsByActor_FirstnameAndActor_Lastname(firstName, lastName).forEach(movieCast -> movies.add(movieCast.getMovie()));
        return movies;
    }

    public List<Actor> getMovieCastsByMovie_Title(String title) {
        List<Actor> actors = new ArrayList<>();
        movieCastRepository.findMovieCastsByMovie_Title(title).forEach(movieCast -> actors.add(movieCast.getActor()));
        return actors;
    }

    public List<Movie> getMoviesWithCastLowerThan(Integer treshold) {
        List<Movie> movies = new ArrayList<>();
        HashMap<String, Integer> counts = new HashMap<>();
        movieRepository.findAll().forEach(movie -> counts.put(movie.getTitle(), 0));
        movieCastRepository.findAll().forEach(movieCast -> counts.put(movieCast.getMovie().getTitle(), counts.get(movieCast.getMovie().getTitle()) + 1));
        counts.forEach((k, v) -> {
            if (v < treshold) movies.add(movieRepository.findByTitle(k));
        });
        return movies;
    }
}
