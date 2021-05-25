package pl.sda.json;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import pl.sda.http.Request;
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
        PutMovieTitleToSearchFromConsole movieTitle = new PutMovieTitleToSearchFromConsole(scanner);
        String searchedMovieTitle = movieTitle.putSearchedMovieTitle();
        System.out.println("Szukany film: " + searchedMovieTitle.toUpperCase(Locale.ROOT));
        AppServiceJpa service = new AppServiceJpa();
        MovieInfoURIGeneratorbyTitle uri = new MovieInfoURIGeneratorbyTitle();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(uri.getByMovieTitle(searchedMovieTitle))
                .build();
        ObjectMapper mapper = new ObjectMapper();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        MovieJson movie1 = mapper.readValue(response.body(), MovieJson.class);
        System.out.println(movie1);
        String actors = movie1.getActors();
        System.out.println(actors);
    }
}

