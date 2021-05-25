package pl.sda;

import pl.sda.uri.MovieInfoURIGenerator;
import pl.sda.view.core.ConsoleLooper;
import pl.sda.view.core.ConsoleView;
import pl.sda.view.core.Menu;
import pl.sda.view.core.MenuItem;

import java.util.Scanner;

public class QueryController {
    private final ConsoleLooper looper;
    private final ConsoleView view;
    private final Scanner input = new Scanner(System.in);

    public QueryController() {
        Menu menu = new Menu();
        MovieInfoURIGenerator uri = new MovieInfoURIGenerator();
        view = new ConsoleView(menu, System.in);
        looper = new ConsoleLooper(view);

        menu.addMenuItem(
                new MenuItem("Wyświetl info o filmie",
                        () -> new APIClient(uri, input)));
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


