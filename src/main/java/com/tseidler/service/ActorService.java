package com.tseidler.service;

import com.tseidler.domain.Actor;
import com.tseidler.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ActorService {
    //setter injection!!!
    @Autowired
    private ActorRepository actorRepository;

    public List<Actor> getAllActors() {
        List<Actor> results = new ArrayList<>();
        Iterable<Actor> temp = actorRepository.findAll();
        temp.forEach(actor -> results.add(actor));
        return results;
    }

    public void addActor(Actor actor) {
        actorRepository.save(actor);
    }

    public List<Actor> findActorByLastname(String lastName) {
        return actorRepository.findAllByLastname(lastName);
    }

    public List<Actor> findActorsByFirsName(String firstName) {
        return actorRepository.findAllByFirstname(firstName);
    }

    public List<Actor> findAllByFirstnameAndLastname(String firstName, String lastName) {
        return actorRepository.findAllByFirstnameAndLastname(firstName, lastName);
    }

}
