package pl.sda.controller;

import pl.sda.entity.MovieJson;
import pl.sda.repository.MovieJsonRepo;
import pl.sda.http.Response;
import pl.sda.mymovies_sql.MyMovies;
import pl.sda.service.AppServiceJpa;
import pl.sda.view.core.ConsoleLooper;
import pl.sda.view.core.ConsoleView;
import pl.sda.view.core.Menu;
import pl.sda.view.core.MenuItem;
import pl.sda.view.domain.PutMovieIdToSearchFromConsole;
import pl.sda.view.domain.PutMovieTitleToSearchFromConsole;
import pl.sda.view.domain.SaveSearchedMovietoDataBase;

import java.net.http.HttpResponse;
import java.util.Locale;
import java.util.Scanner;

public class QueryController {
    private final ConsoleLooper looper;
    private final ConsoleView view;
    private final Scanner input = new Scanner(System.in);

    public QueryController() {
        Menu menu = new Menu();
        view = new ConsoleView(menu, System.in);
        looper = new ConsoleLooper(view);
        AppServiceJpa service = new AppServiceJpa();

        menu.addMenuItem(
                new MenuItem("Wyświetl info o filmie poprzez tytuł",
                        () -> {
                            PutMovieTitleToSearchFromConsole movieTitle = new PutMovieTitleToSearchFromConsole(input);
                            String searchedMovieTitle = movieTitle.putSearchedMovieTitle(); //String
                            System.out.println("Szukany film: " + searchedMovieTitle.toUpperCase(Locale.ROOT));
                            service.sendRequestViaTitle(searchedMovieTitle);
                            SaveSearchedMovietoDataBase saveSearchedMovietoDataBase = new SaveSearchedMovietoDataBase();
                            saveSearchedMovietoDataBase.saveSearchedMovie(input,searchedMovieTitle);
                        }));
        menu.addMenuItem(
                new MenuItem("Wyświetl info o filmie poprzez id",
                        () -> {
                            PutMovieIdToSearchFromConsole id = new PutMovieIdToSearchFromConsole(input);
                            String searchedMovieId = id.putSearchedMovieId();//String
                            System.out.println("Szukany film: " + searchedMovieId);
                            service.sendRequestViaId(searchedMovieId);
                        }));
        menu.addMenuItem(
                new MenuItem("Wyświetl aktorów filmu",
                        () -> {
                            service.showActors(input);
                        }));
        menu.addMenuItem(
                new MenuItem("Wyświetl rok produkcji filmu",
                        () -> {
                            service.showYear(input);
                        }));
        menu.addMenuItem(
                new MenuItem("Wyświetl BoxOffice",
                        () -> {
                            service.showBoxOffice(input);
                        }));
        menu.addMenuItem(
                new MenuItem("Wyświetl reżysera",
                        () -> {
                            service.showDirector(input);
                        }));
        menu.addMenuItem(
                new MenuItem("Wyświetl nagrody",
                        () -> {
                            service.showAwards(input);
                        }));
        menu.addMenuItem(
                new MenuItem("Wyświetl Imdb id",
                        () -> {
                            service.showImdbId(input);
                        }));
        menu.addMenuItem(new MenuItem(
                "Zakończ",
                Menu.DEFAULT_QUIT
        ));
    }

    public void start() {
        looper.runLoop();
    }
}



