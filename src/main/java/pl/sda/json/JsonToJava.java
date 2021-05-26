package pl.sda.json;


import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.entity.MovieJson;
import pl.sda.http.Request;
import pl.sda.http.Response;
import pl.sda.service.AppServiceJpa;
import pl.sda.uri.MovieInfoURIGeneratorbyTitle;
import pl.sda.view.domain.PutMovieTitleToSearchFromConsole;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Locale;
import java.util.Scanner;

public class JsonToJava {

    public void showActors(Scanner scanner) throws URISyntaxException, IOException, InterruptedException {
        JsonToJavaService service = new JsonToJavaService();
        MovieJson movieJson = service.searchBy(scanner);
        System.out.println(movieJson.getActors());
    }

    public void showYear(Scanner scanner) throws URISyntaxException, IOException, InterruptedException {
        JsonToJavaService service = new JsonToJavaService();
        MovieJson movieJson = service.searchBy(scanner);
        System.out.println(movieJson.getYear());
    }

    public void showAwards(Scanner scanner) throws URISyntaxException, IOException, InterruptedException {
        JsonToJavaService service = new JsonToJavaService();
        MovieJson movieJson = service.searchBy(scanner);
        System.out.println(movieJson.getAwards());
    }

    public void showDirector(Scanner scanner) throws URISyntaxException, IOException, InterruptedException {
        JsonToJavaService service = new JsonToJavaService();
        MovieJson movieJson = service.searchBy(scanner);
        System.out.println(movieJson.getDirector());
    }

    public void showWriter(Scanner scanner) throws URISyntaxException, IOException, InterruptedException {
        JsonToJavaService service = new JsonToJavaService();
        MovieJson movieJson = service.searchBy(scanner);
        System.out.println(movieJson.getWriter());
    }

    public void getCountry(Scanner scanner) throws URISyntaxException, IOException, InterruptedException {
        JsonToJavaService service = new JsonToJavaService();
        MovieJson movieJson = service.searchBy(scanner);
        System.out.println(movieJson.getCountry());
    }

    public void showImdbRating(Scanner scanner) throws URISyntaxException, IOException, InterruptedException {
        JsonToJavaService service = new JsonToJavaService();
        MovieJson movieJson = service.searchBy(scanner);
        System.out.println(movieJson.getImdbRating());
    }

    public void showBoxOffice(Scanner scanner) throws URISyntaxException, IOException, InterruptedException {
        JsonToJavaService service = new JsonToJavaService();
        MovieJson movieJson = service.searchBy(scanner);
        System.out.println(movieJson.getBoxOffice());
    }

    public void showGenre(Scanner scanner) throws URISyntaxException, IOException, InterruptedException {
        JsonToJavaService service = new JsonToJavaService();
        MovieJson movieJson = service.searchBy(scanner);
        System.out.println(movieJson.getGenre());
    }

    public void showImdbVotes(Scanner scanner) throws URISyntaxException, IOException, InterruptedException {
        JsonToJavaService service = new JsonToJavaService();
        MovieJson movieJson = service.searchBy(scanner);
        System.out.println(movieJson.getImdbVotes());
    }

    public void showLanguage(Scanner scanner) throws URISyntaxException, IOException, InterruptedException {
        JsonToJavaService service = new JsonToJavaService();
        MovieJson movieJson = service.searchBy(scanner);
        System.out.println(movieJson.getLanguage());
    }

    public void showPlot(Scanner scanner) throws URISyntaxException, IOException, InterruptedException {
        JsonToJavaService service = new JsonToJavaService();
        MovieJson movieJson = service.searchBy(scanner);
        System.out.println(movieJson.getPlot());
    }

    public void showWebsite(Scanner scanner) throws URISyntaxException, IOException, InterruptedException {
        JsonToJavaService service = new JsonToJavaService();
        MovieJson movieJson = service.searchBy(scanner);
        System.out.println(movieJson.getWebsite());
    }

    public void showImdbId(Scanner scanner) throws URISyntaxException, IOException, InterruptedException {
        JsonToJavaService service = new JsonToJavaService();
        MovieJson movieJson = service.searchBy(scanner);
        System.out.println(movieJson.getImdbID());
    }

    public void showMovieDuration(Scanner scanner) throws URISyntaxException, IOException, InterruptedException {
        JsonToJavaService service = new JsonToJavaService();
        MovieJson movieJson = service.searchBy(scanner);
        System.out.println(movieJson.getRuntime());
    }

    public void showReleasedYear(Scanner scanner) throws URISyntaxException, IOException, InterruptedException {
        JsonToJavaService service = new JsonToJavaService();
        MovieJson movieJson = service.searchBy(scanner);
        System.out.println(movieJson.getReleased());
    }
}
