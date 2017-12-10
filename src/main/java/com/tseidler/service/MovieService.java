package com.tseidler.service;

import com.tseidler.domain.Movie;
import com.tseidler.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MovieService {
    //constructor injection!!!
    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public void addMovies(ArrayList<Movie> movies) {
        movieRepository.save(movies);
    }

    public Movie findByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    public ArrayList<Movie> getMovies() {
        ArrayList<Movie> results = new ArrayList<>();
        movieRepository.findAll().forEach(movie -> results.add(movie));
        return results;
    }
}
