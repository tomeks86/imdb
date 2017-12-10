package com.tseidler.repository;

import com.tseidler.domain.MovieCast;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieCastRepository extends CrudRepository<MovieCast, Integer> {

    List<MovieCast> findMovieCastsByActor_Lastname(String lastName);

    List<MovieCast> findMovieCastsByMovie_Title(String title);
}
