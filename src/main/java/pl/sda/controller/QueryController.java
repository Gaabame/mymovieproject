package pl.sda.controller;

import pl.sda.service.AppServiceJpa;
import pl.sda.view.core.ConsoleLooper;
import pl.sda.view.core.ConsoleView;
import pl.sda.view.core.Menu;
import pl.sda.view.core.MenuItem;
import pl.sda.view.domain.PutMovieIdToSearchFromConsole;
import pl.sda.view.domain.PutMovieTitleToSearchFromConsole;
import pl.sda.view.domain.SaveSearchedMovietoDataBase;
import pl.sda.view.domain.FindMovieFromSQL;

import java.util.Locale;
import java.util.Scanner;

public class QueryController {
    private final ConsoleLooper looper;
    private final ConsoleView view;
    private final Scanner input = new Scanner(System.in);

    public QueryController() {
        Menu menu = new Menu();
        Menu menuSearch = new Menu();
        view = new ConsoleView(menu, System.in);
        looper = new ConsoleLooper(view);
        AppServiceJpa service = new AppServiceJpa();

        menu.addMenuItem(
                new MenuItem("Wyszukaj info o filmie poprzez tytuł",
                        () -> {
                            PutMovieTitleToSearchFromConsole movieTitle = new PutMovieTitleToSearchFromConsole(input);
                            String searchedMovieTitle = movieTitle.putSearchedMovieTitle(); //String
                            System.out.println("Szukany film: " + searchedMovieTitle.toUpperCase(Locale.ROOT));
                            service.getMovieByTitle(searchedMovieTitle);
                            SaveSearchedMovietoDataBase saveSearchedMovietoDataBase = new SaveSearchedMovietoDataBase();
                            saveSearchedMovietoDataBase.saveSearchedMovie(input,searchedMovieTitle);
                        }));
        menu.addMenuItem(
                new MenuItem("Wyszukaj info o filmie poprzez id",
                        () -> {
                            PutMovieIdToSearchFromConsole id = new PutMovieIdToSearchFromConsole(input);
                            String searchedMovieId = id.putSearchedMovieId();//String
                            System.out.println("Szukany film: " + searchedMovieId);
                            service.getMovieById(searchedMovieId);
                            SaveSearchedMovietoDataBase saveSearchedMovietoDataBase = new SaveSearchedMovietoDataBase();
                            saveSearchedMovietoDataBase.saveSearchedMovie(input,searchedMovieId);
                        }));
        menu.addMenuItem(
                new MenuItem("Odczytaj film z bazy",
                        () -> {
                            PutMovieTitleToSearchFromConsole title = new PutMovieTitleToSearchFromConsole(input);
                            String searchedMovieTitle = title.putSearchedMovieTitle();
                            FindMovieFromSQL show = new FindMovieFromSQL();
                            show.findMovieFromSQL(searchedMovieTitle);
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
        menu.addMenuItem(
                new MenuItem("Wyświetl aktorów",
                        () -> {
                            service.showActors(input);
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



