package com.tseidler.repository;

import com.tseidler.domain.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

    Movie findByTitle(String title);

}
