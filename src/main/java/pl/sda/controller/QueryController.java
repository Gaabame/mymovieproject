package pl.sda.controller;

import pl.sda.entity.MovieJson;
import pl.sda.service.AppServiceJpa;
import pl.sda.service.MyBaseServiceJpa;
import pl.sda.view.core.ConsoleLooper;
import pl.sda.view.core.ConsoleView;
import pl.sda.view.core.Menu;
import pl.sda.view.core.MenuItem;
import pl.sda.view.domain.PutMovieIdToSearchFromConsole;
import pl.sda.view.domain.PutMovieTitleToSearchFromConsole;

import java.util.Locale;
import java.util.Scanner;

public class QueryController {
    private final ConsoleLooper looper;
    private final ConsoleView view;
    private final Scanner input = new Scanner(System.in);

    public QueryController(AppServiceJpa service, MyBaseServiceJpa myBaseService) {
        Menu menu = new Menu();
        view = new ConsoleView(menu, System.in);
        looper = new ConsoleLooper(view);

        menu.addMenuItem(
                new MenuItem("Wyszukaj info o filmie poprzez tytuł",
                        () -> {
                            PutMovieTitleToSearchFromConsole movieTitle = new PutMovieTitleToSearchFromConsole(input);
                            String searchedMovieTitle = movieTitle.putSearchedMovieTitle(); //String
                            System.out.println("Szukany film: " + searchedMovieTitle.toUpperCase(Locale.ROOT));
                            MovieJson movie = service.getMovieByTitle(searchedMovieTitle);
                            if (movie != null) {
                                System.out.println("Czy chcesz zapisac film do bazy? T/N");
                                if (input.nextLine().toUpperCase(Locale.ROOT).equals("T")) {
                                    myBaseService.saveMovieIntoMyBase(movie);
                                }
                            }
                        }));
        menu.addMenuItem(
                new MenuItem("Wyszukaj info o filmie poprzez id Imdb",
                        () -> {
                            PutMovieIdToSearchFromConsole id = new PutMovieIdToSearchFromConsole(input);
                            String searchedMovieId = id.putSearchedMovieImdbId();//String
                            System.out.println("Szukany film: " + searchedMovieId);
                            MovieJson movieById = service.getMovieById(searchedMovieId);
                            if (movieById != null) {
                                System.out.println("Czy chcesz zapisac film do bazy? T/N");
                                if (input.nextLine().toUpperCase(Locale.ROOT).equals("T")) {
                                    myBaseService.saveMovieIntoMyBase(movieById);
                                }
                            }
                        }));
        menu.addMenuItem(
                new MenuItem("Wyświetl filmy zapisane w bazie",
                        () -> {
                            myBaseService.printMovieTitlesSavedInMyBase();
                        }));
        menu.addMenuItem(
                new MenuItem("Wyszukaj film zapisany w bazie po tytule",
                        () -> {
                            PutMovieTitleToSearchFromConsole movieTitle = new PutMovieTitleToSearchFromConsole(input);
                            String searchedMovieTitle = movieTitle.putSearchedMovieTitle();
                            myBaseService.findMovieFromBaseByTitle(searchedMovieTitle);
                        }));
        menu.addMenuItem(
                new MenuItem("Wyszukaj film zapisany w bazie po id",
                        () -> {
                            PutMovieIdToSearchFromConsole id = new PutMovieIdToSearchFromConsole(input);
                            Long movieIdFromBase = id.putSearchedMovieIdFromBase();
                            myBaseService.findMovieFromBaseById(movieIdFromBase);
                        }));
        menu.addMenuItem(
                new MenuItem("Usuń film z bazy",
                        () -> {
                            PutMovieIdToSearchFromConsole id = new PutMovieIdToSearchFromConsole(input);
                            Long movieIdFromBase = id.putSearchedMovieIdFromBase();
                            myBaseService.deleteMovieFromMyBase(movieIdFromBase);
                        }));
        menu.addMenuItem(
                new MenuItem("Wyświetl BoxOffice filmu",
                        () -> {
                            PutMovieTitleToSearchFromConsole movieTitle = new PutMovieTitleToSearchFromConsole(input);
                            String searchedMovieTitle = movieTitle.putSearchedMovieTitle();
                            service.showBoxOffice(searchedMovieTitle);
                        }));
        menu.addMenuItem(
                new MenuItem("Wyświetl reżysera",
                        () -> {
                            PutMovieTitleToSearchFromConsole movieTitle = new PutMovieTitleToSearchFromConsole(input);
                            String searchedMovieTitle = movieTitle.putSearchedMovieTitle();
                            service.showDirector(searchedMovieTitle);
                        }));
        menu.addMenuItem(
                new MenuItem("Wyświetl Imdb id",
                        () -> {
                            PutMovieTitleToSearchFromConsole movieTitle = new PutMovieTitleToSearchFromConsole(input);
                            String searchedMovieTitle = movieTitle.putSearchedMovieTitle();
                            service.showImdbId(searchedMovieTitle);
                        }));
        menu.addMenuItem(
                new MenuItem("Wyświetl aktorów",
                        () -> {
                            PutMovieTitleToSearchFromConsole movieTitle = new PutMovieTitleToSearchFromConsole(input);
                            String searchedMovieTitle = movieTitle.putSearchedMovieTitle();
                            service.showActors(searchedMovieTitle);
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



