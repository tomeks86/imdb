package com.tseidler.repository;

import com.tseidler.domain.MovieDetail;
import org.springframework.data.repository.CrudRepository;

public interface MovieDetailRepository extends CrudRepository<MovieDetail, Integer> {
}
