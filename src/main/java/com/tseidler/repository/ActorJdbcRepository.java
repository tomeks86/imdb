package com.tseidler.repository;

import com.tseidler.domain.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ActorJdbcRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Actor findByID(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM actor WHERE id = ?", new Object[] {id},
                new BeanPropertyRowMapper<Actor>(Actor.class));
    }
}
