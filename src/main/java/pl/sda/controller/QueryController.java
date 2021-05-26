package pl.sda.controller;

import pl.sda.repository.MovieJsonRepo;
import pl.sda.http.Response;
import pl.sda.json.JsonToJava;
import pl.sda.mymovies_sql.MyMovies;
import pl.sda.service.AppServiceJpa;
import pl.sda.view.core.ConsoleLooper;
import pl.sda.view.core.ConsoleView;
import pl.sda.view.core.Menu;
import pl.sda.view.core.MenuItem;
import pl.sda.view.domain.PutMovieIdToSearchFromConsole;
import pl.sda.view.domain.PutMovieTitleToSearchFromConsole;

import java.io.IOException;
import java.net.URISyntaxException;
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
                                Response response = new Response();
                                HttpResponse<String> responseByTitle = null;
                                try {
                                    responseByTitle = response.getResponseByTitle(searchedMovieTitle);
                                } catch (URISyntaxException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                String body = responseByTitle.body();
//                                MovieJson buildJson = MovieJson.builder().country("USA").title("Blade Runner").year("1982").build();
                                MyMovies myMovies = new MyMovies();
                                MovieJsonRepo movieJsonRepo = myMovies.getfactory();
                                movieJsonRepo.save(body);
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
        menu.addMenuItem(
                new MenuItem("Wyświetl rok produkcji filmu",
                        () -> {
                            JsonToJava jsonToJava = new JsonToJava();
                            try {
                                jsonToJava.showYear(input);
                            } catch (URISyntaxException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }));
        menu.addMenuItem(
                new MenuItem("Wyświetl BoxOffice",
                        () -> {
                            JsonToJava jsonToJava = new JsonToJava();
                            try {
                                jsonToJava.showBoxOffice(input);
                            } catch (URISyntaxException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }));
        menu.addMenuItem(
                new MenuItem("Wyświetl reżysera",
                        () -> {
                            JsonToJava jsonToJava = new JsonToJava();
                            try {
                                jsonToJava.showDirector(input);
                            } catch (URISyntaxException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }));
        menu.addMenuItem(
                new MenuItem("Wyświetl nagrody",
                        () -> {
                            JsonToJava jsonToJava = new JsonToJava();
                            try {
                                jsonToJava.showAwards(input);
                            } catch (URISyntaxException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }));
        menu.addMenuItem(
                new MenuItem("Wyświetl Imdb id",
                        () -> {
                            JsonToJava jsonToJava = new JsonToJava();
                            try {
                                jsonToJava.showImdbId(input);
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


