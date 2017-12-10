package com.tseidler.repository;

import com.tseidler.domain.Actor;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ActorRepository extends CrudRepository<Actor, Integer> {

    public ArrayList<Actor> findAllByLastname(String lastName);

    public ArrayList<Actor> findAllByFirstname(String lastName);

    public ArrayList<Actor> findAllByFirstnameAndLastname(String firstName, String lastName);
}
