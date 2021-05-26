package pl.sda.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.entity.MovieJson;
import pl.sda.http.Request;
import pl.sda.http.Response;
import pl.sda.service.AppServiceJpa;
import pl.sda.view.domain.PutMovieTitleToSearchFromConsole;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Locale;
import java.util.Scanner;

public class JsonToJavaService {

    public MovieJson searchBy(Scanner scanner) throws URISyntaxException, IOException, InterruptedException {
        PutMovieTitleToSearchFromConsole movieTitle = new PutMovieTitleToSearchFromConsole(scanner);
        String searchedMovieTitle = movieTitle.putSearchedMovieTitle();
        AppServiceJpa service = new AppServiceJpa();
        Request request = new Request();
        HttpRequest requestByTitle = request.getRequestByTitle(searchedMovieTitle);
        ObjectMapper mapper = new ObjectMapper();
        Response response = new Response();
        HttpResponse<String> responseByTitle = response.getResponseByTitle(searchedMovieTitle);
        String body = responseByTitle.body();
        MovieJson movieJson = mapper.readValue(body, MovieJson.class);
        return movieJson;
    }

}
