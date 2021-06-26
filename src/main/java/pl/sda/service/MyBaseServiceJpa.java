package pl.sda.service;

import pl.sda.entity.MovieJson;
import pl.sda.repositoryBase.MovieJsonRepoAPI;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;
import java.util.stream.Collectors;

public class MyBaseServiceJpa implements MyBaseService {

    public static final String MYMOVIES = "mymovies";

    EntityManagerFactory factory = Persistence.createEntityManagerFactory(MYMOVIES);
    MovieJsonRepoAPI repo = new MovieJsonRepoAPI(factory, MovieJson.class);


    @Override
    public void printMovieTitlesSavedInMyBase(){
        String collect = repo.findAll().stream()
                .map(movie -> String.format(
                        "| %-5s | %-20s | %-20s | %-10s |", movie.getId(), movie.getTitle(), movie.getDirector(), movie.getYear()
                ))
                .collect(Collectors.joining("\n"));
        System.out.println(collect);
    }

    @Override
    public void saveMovieIntoMyBase(MovieJson movieJson) {
        repo.save(movieJson);
        System.out.println("Zapisano film");

    }
//TODO dokonczyć funkcję delete movie
    @Override
    public void deleteMovieFromMyBase(Long id) {
        Optional<MovieJson> result = repo.findById(id).stream().findFirst();
        repo.delete(result);
    }

    @Override
    public void findMovieFromBaseById(Long id) {
        Optional<MovieJson> movieJson = repo.findById(id).stream().findFirst();
        if (movieJson.isEmpty()) {
            System.out.println("Nie znaleziono filmu o podanym tytule w bazie");
        } else {
            System.out.println("Znaleziono film: " + movieJson);
        }
    }

    @Override
    public void findMovieFromBaseByTitle(String title) {
        Optional<MovieJson> movieJson = repo.findByTitle(title).stream().findFirst();
        if (movieJson.isEmpty()) {
            System.out.println("Nie znaleziono filmu o podanym tytule w bazie");
        } else {
            System.out.println("Znaleziono film: " + movieJson);
        }
    }
}
