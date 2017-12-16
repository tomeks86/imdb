package com.tseidler;

import com.tseidler.domain.*;
import com.tseidler.repository.ActorJdbcRepository;
import com.tseidler.service.MovieCastService;
import com.tseidler.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.tseidler.service.ActorService;

import javax.swing.tree.RowMapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ImdbApplication implements CommandLineRunner {

    @Autowired
    private ActorService actorService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieCastService movieCastService;
    @Autowired
    ActorJdbcRepository actorJdbcRepository;


    public static Connection con = null;
    public static Connection getConection() {
        if (con == null) {
            try {
                con = DriverManager.getConnection("jdbc:h2:mem:imdb", "sa", "");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return con;
    }
    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
		SpringApplication.run(ImdbApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {
        Actor stefan_beton = new Actor("Stefan", "Beton");
        Actor franek_smietana = new Actor("Franek", "Śmietana");
        Actor jozef_beton = new Actor("Józef", "Beton");
        Actor molibdenowy_mateusz = new Actor("Mateusz", "Molibdenowy");
        Actor tytanowy_janusz = new Actor("Janusz", "Tytanowy");
        Actor franek_smietana_2 = new Actor("Franek", "Śmietana");
        actorService.addActor(stefan_beton);
        actorService.addActor(franek_smietana);
        actorService.addActor(jozef_beton);
        actorService.addActor(molibdenowy_mateusz);
        actorService.addActor(tytanowy_janusz);
        actorService.addActor(franek_smietana_2);
        List<Actor> myChampion = actorService.findActorByLastname("Beton");
        System.out.println(myChampion.toString());
        List<Actor> actors = actorService.getAllActors();
        actors.forEach(act -> System.out.println(act.toString()));
        System.out.println();
        List<Actor> actors2 = actorService.findAllByFirstnameAndLastname("Franek", "Śmietana");
        actors2.forEach(act -> System.out.println(act.toString()));
        System.out.println();

        Movie sarnie_zniwo = new Movie("Sarnie żniwo");
        sarnie_zniwo.setMovieDetail(new MovieDetail("superancki film, aktualny nawet w 2050 roku!"));
        Movie pocalunek_kojota = new Movie("Pocałunek kojota");
        //pocalunek_kojota.setMovieDetail(new MovieDetail("thriller zoofiliczny"));
        Movie browar_awruk = new Movie("Zmierzch browaru \"AWRUK\"");
        browar_awruk.setMovieDetail(new MovieDetail("film o upadku pewnego bardzo znanego browaru"));
        Movie abc_przedszkolaka = new Movie("ABC przedszkolaka");
        abc_przedszkolaka.setMovieDetail(new MovieDetail("taki film edukacyjny, \"co i jak\" w przedszkolu :)"));
        Movie abc_pierwszaka = new Movie("ABC pierwszaka");
        abc_pierwszaka.setMovieDetail(new MovieDetail("taki film edukacyjny, \"co i jak\" w podstawówce :)"));
        Movie masarnia_satuk = new Movie("Masarnia Satuk");
        //masarnia_satuk.setMovieDetail(new MovieDetail("dokument o pewnej ekskluzywnej masarni"));

        movieService.addMovie(sarnie_zniwo);
        movieService.addMovie(pocalunek_kojota);
        movieService.addMovie(browar_awruk);
        List<Movie> movies = new ArrayList<>();
        movies.add(abc_przedszkolaka);
        movies.add(abc_pierwszaka);
        movies.add(masarnia_satuk);
        movieService.addMovies(movies);


        List<Movie> moviesList = movieService.getMovies();
        moviesList.forEach(mv -> System.out.println(mv.toString()));

        MovieCast movieCast1 = new MovieCast(sarnie_zniwo, stefan_beton);
        MovieCast movieCast2 = new MovieCast(sarnie_zniwo, tytanowy_janusz);
        MovieCast movieCast3 = new MovieCast(sarnie_zniwo, molibdenowy_mateusz);
        MovieCast movieCast4 = new MovieCast(pocalunek_kojota, franek_smietana_2);
        MovieCast movieCast5 = new MovieCast(pocalunek_kojota, franek_smietana);
        MovieCast movieCast6 = new MovieCast(abc_pierwszaka, jozef_beton);
        MovieCast movieCast7 = new MovieCast(abc_pierwszaka, stefan_beton);
        MovieCast movieCast8 = new MovieCast(abc_przedszkolaka, jozef_beton);
        movieCastService.addMovieCast(movieCast1);
        movieCastService.addMovieCast(movieCast2);
        movieCastService.addMovieCast(movieCast3);
        movieCastService.addMovieCast(movieCast4);
        movieCastService.addMovieCast(movieCast5);
        movieCastService.addMovieCast(movieCast6);
        movieCastService.addMovieCast(movieCast7);
        movieCastService.addMovieCast(movieCast8);

        System.out.println();
        System.out.println("Films where Beton is playing:");
        List<Movie> movies_beton = movieCastService.getMovieCastsByActor_Lastname("Beton");
        movies_beton.forEach(movie -> System.out.println(movie.toString()));
        System.out.println();
        System.out.println("Films where Stefan Beton is playing:");
        List<Movie> movies_stefan_beton = movieCastService.getMovieCastsByActor_FirstnameAndActor_Lastname("Stefan", "Beton");
        movies_stefan_beton.forEach(movie -> System.out.println(movie.toString()));
        System.out.println();
        System.out.println("Actors playing in Sarnie żniwo:");
        List<Actor> actors_sarnie = movieCastService.getMovieCastsByMovie_Title("Sarnie żniwo");
        actors_sarnie.forEach(actor -> System.out.println(actor.toString()));
        System.out.println();
        System.out.println("Movies with no actor:");
        List<Movie> movies_noactor = movieCastService.getMoviesWithCastLowerThan(1);
        movies_noactor.forEach(movie -> System.out.println(movie.toString()));
        System.out.println();

        Connection h2 = getConection();
        ResultSet rs = h2.createStatement().executeQuery("SELECT title FROM film");
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
        System.out.println();
        /*rs = h2.createStatement().executeQuery("SELECT * FROM actor");
        ActorMaper actorMaper = new ActorMaper();
        Actor pierwszy = actorMaper.mapRow(rs, 1);
        System.out.println(pierwszy.toString());*/
        Actor first = actorJdbcRepository.findByID(1);
        System.out.println(first.toString());
        closeConnection(h2);

    }
}
