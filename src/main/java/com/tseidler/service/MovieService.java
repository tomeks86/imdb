package com.tseidler.service;

import com.tseidler.domain.Movie;
import com.tseidler.repository.MovieDetailRepository;
import com.tseidler.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MovieService {
    /*//constructor injection!!!
    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }*/

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieDetailRepository movieDetailRepository;

    public void addMovie(Movie movie) {
        if (movie.getMovieDetail() != null) {
            movieDetailRepository.save(movie.getMovieDetail());
        }
        movieRepository.save(movie);
    }

    public void addMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            addMovie(movie);
        }
    }

    public Movie findByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    public List<Movie> getMovies() {
        List<Movie> results = new ArrayList<>();
        movieRepository.findAll().forEach(movie -> results.add(movie));
        return results;
    }
}
