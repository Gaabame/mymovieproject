package pl.sda.service;

import pl.sda.entity.MovieJson;

import java.util.Scanner;

public interface AppService {

    MovieJson getMovieByTitle(String title);
    MovieJson getMovieById(String id);
    void showActors(Scanner scanner);
    void showYear(Scanner scanner);
    void showAwards(Scanner scanner);
    void showDirector(Scanner scanner);
//    void showWriter(Scanner scanner);
//    void getCountry(Scanner scanner);
//    void showImdbRating(Scanner scanner);
    void showBoxOffice(Scanner scanner);
//    void showGenre(Scanner scanner);
//    void showImdbVotes(Scanner scanner);
//    void showLanguage(Scanner scanner);
//    void showPlot(Scanner scanner);
//    void showWebsite(Scanner scanner);
    void showImdbId(Scanner scanner);
//    void showMovieDuration(Scanner scanner);
//    void showReleasedYear(Scanner scanner);

}
