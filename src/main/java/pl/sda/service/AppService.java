package pl.sda.service;

import pl.sda.entity.MovieJson;
public interface AppService {

    MovieJson getMovieByTitle(String title);
    MovieJson getMovieById(String id);
    void showActors(String title);
    void showBoxOffice(String title);
    void showImdbId(String title);
    void showDirector(String title);


}
