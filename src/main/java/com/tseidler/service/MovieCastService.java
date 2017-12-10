package com.tseidler.service;

import com.tseidler.domain.MovieCast;
import com.tseidler.repository.MovieCastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieCastService {
    @Autowired
    private MovieCastRepository movieCastRepository;

    public void addMovieCast(MovieCast movieCast) {
        movieCastRepository.save(movieCast);
    }

    public List<MovieCast> getCasts() {
        List<MovieCast> result = new ArrayList<>();
        movieCastRepository.findAll().forEach(movie -> result.add(movie));
        return result;
    }

    List<MovieCast> findMovieCastsByActor_Lastname(String lastName) {
        return movieCastRepository.findMovieCastsByActor_Lastname(lastName);
    }

    List<MovieCast> findMovieCastsByMovie_Title(String title) {
        return  movieCastRepository.findMovieCastsByMovie_Title(title);
    }
}
