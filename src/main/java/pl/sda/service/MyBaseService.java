package pl.sda.service;

import pl.sda.entity.MovieJson;

public interface MyBaseService {

    void printMovieTitlesSavedInMyBase();
    void saveMovieIntoMyBase(MovieJson movieJson);
    void deleteMovieFromMyBase(Long id);
    void findMovieFromBaseByTitle(String input);
    void findMovieFromBaseById(Long id);

}
