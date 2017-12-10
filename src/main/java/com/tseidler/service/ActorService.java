package com.tseidler.service;

import com.tseidler.domain.Actor;
import com.tseidler.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ActorService {
    //setter injection!!!
    @Autowired
    private ActorRepository actorRepository;

    public ArrayList<Actor> getAllActors() {
        ArrayList<Actor> results = new ArrayList<>();
        Iterable<Actor> temp = actorRepository.findAll();
        temp.forEach(actor -> results.add(actor));
        return results;
    }

    public void addActor(Actor actor) {
        actorRepository.save(actor);
    }

    public ArrayList<Actor> findActorByLastname(String lastName) {
        return actorRepository.findAllByLastname(lastName);
    }

    public ArrayList<Actor> findActorsByFirsName(String firstName) {
        return actorRepository.findAllByFirstname(firstName);
    }

    public ArrayList<Actor> findAllByFirstnameAndLastname(String firstName, String lastName) {
        return actorRepository.findAllByFirstnameAndLastname(firstName, lastName);
    }

}
