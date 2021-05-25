package pl.sda;

import pl.sda.uri.MovieInfoURIGenerator;
import pl.sda.view.core.ConsoleLooper;
import pl.sda.view.core.ConsoleView;
import pl.sda.view.core.Menu;
import pl.sda.view.core.MenuItem;
import pl.sda.view.domain.PutMovieTitleToSearchForFromConsole;

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

        menu.addMenuItem(
                new MenuItem("Wyświetl info o filmie",
                        () -> {
                    PutMovieTitleToSearchForFromConsole movieTitle = new PutMovieTitleToSearchForFromConsole(input);
                            String searchedMovieTitle = movieTitle.putSearchedMovieTitle(); //String
                            System.out.println("Szukany film: " + searchedMovieTitle.toUpperCase(Locale.ROOT));
                            APIClient client = new APIClient();
                            try {
                                client.clientAPI(searchedMovieTitle);
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } catch (URISyntaxException e) {
                                e.printStackTrace();
                            }
                            //searchemovie String wpiszę do clientaApi
                        }
                        ));

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


