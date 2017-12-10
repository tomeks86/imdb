package com.tseidler;

import com.tseidler.domain.Actor;
import com.tseidler.domain.Movie;
import com.tseidler.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.tseidler.service.ActorService;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ImdbApplication implements CommandLineRunner {

    @Autowired
    private ActorService actorService;

    @Autowired
    private MovieService movieService;


    public static void main(String[] args) {
		SpringApplication.run(ImdbApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {
        actorService.addActor(new Actor("Stefan", "Beton"));
        actorService.addActor(new Actor("Franek", "Śmietana"));
        actorService.addActor(new Actor("Józef", "Beton"));
        actorService.addActor(new Actor("Mateusz", "Molibdenowy"));
        actorService.addActor(new Actor("Janusz", "Tytanowy"));
        actorService.addActor(new Actor("Franek", "Śmietana"));
        ArrayList<Actor> myChampion = actorService.findActorByLastname("Beton");
        System.out.println(myChampion.toString());
        ArrayList<Actor> actors = actorService.getAllActors();
        actors.forEach(act -> System.out.println(act.toString()));
        System.out.println();
        ArrayList<Actor> actors2 = actorService.findAllByFirstnameAndLastname("Franek", "Śmietana");
        actors2.forEach(act -> System.out.println(act.toString()));
        System.out.println();

        movieService.addMovie(new Movie("Sarnie żniwo"));
        movieService.addMovie(new Movie("Pocałunek kojota"));
        movieService.addMovie(new Movie("Zmierzch browaru \"AWRUK\""));
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("ABC przedszkolaka"));
        movies.add(new Movie("ABC pierwszaka"));
        movies.add(new Movie("Masarnia Satuk - dokument"));
        movieService.addMovies(movies);


        ArrayList<Movie> moviesList = movieService.getMovies();
        moviesList.forEach(mv -> System.out.println(mv));

    }
}
