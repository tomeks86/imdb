package com.tseidler.repository;

import com.tseidler.domain.Actor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActorRepository extends CrudRepository<Actor, Integer> {

    public List<Actor> findAllByLastname(String lastName);

    public List<Actor> findAllByFirstname(String lastName);

    public List<Actor> findAllByFirstnameAndLastname(String firstName, String lastName);
}
