package pl.sda.controller;

import pl.sda.entitymanager.MovieJsonRepo;
import pl.sda.json.JsonToJava;
import pl.sda.json.MovieJson;
import pl.sda.service.AppServiceJpa;
import pl.sda.view.core.ConsoleLooper;
import pl.sda.view.core.ConsoleView;
import pl.sda.view.core.Menu;
import pl.sda.view.core.MenuItem;
import pl.sda.view.domain.PutMovieIdToSearchFromConsole;
import pl.sda.view.domain.PutMovieTitleToSearchFromConsole;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.net.URISyntaxException;
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
                            try {
                                service.sendRequestViaTitle(searchedMovieTitle);
                            } catch (URISyntaxException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("Czy chcesz zapisać film do bazy danych? T/N");
                            if (input.nextLine().toUpperCase(Locale.ROOT).equals("T")){
                                MovieJson buildJson = MovieJson.builder().country("USA").title("Blade Runner").year("1982").build();
                                EntityManagerFactory factory = Persistence.createEntityManagerFactory("mymovies");
                                MovieJsonRepo movieJsonRepo = new MovieJsonRepo(factory);
                                movieJsonRepo.save(buildJson);

                            }
                        }));
        menu.addMenuItem(
                new MenuItem("Wyświetl info o filmie poprzez id",
                        () -> {
                            PutMovieIdToSearchFromConsole id = new PutMovieIdToSearchFromConsole(input);
                            String searchedMovieId = id.putSearchedMovieId();//String
                            System.out.println("Szukany film: " + searchedMovieId);
                            try {
                                service.sendRequestViaId(searchedMovieId);
                            } catch (URISyntaxException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }));

        menu.addMenuItem(
                new MenuItem("Wyświetl aktorów filmu",
                        () -> {
                            JsonToJava jsonToJava = new JsonToJava();
                            try {
                                jsonToJava.showActors(input);
                            } catch (URISyntaxException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
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


//        MovieInfoURIGenerator generator = new MovieInfoURIGenerator();
//        try {
//            URI blade_runner = generator.getByMovieTitle("blade runner");
//            System.out.println(blade_runner);
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//    }


