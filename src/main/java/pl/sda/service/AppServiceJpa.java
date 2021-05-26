package pl.sda.service;

import pl.sda.http.Request;
import pl.sda.uri.MovieInfoURIGeneratorbyId;
import pl.sda.uri.MovieInfoURIGeneratorbyTitle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AppServiceJpa implements AppService {

    @Override
    public void sendRequestViaId(String id) throws URISyntaxException, IOException, InterruptedException {
        MovieInfoURIGeneratorbyId uri = new MovieInfoURIGeneratorbyId();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(uri.getbyMovieId(id))
                .build();
        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            System.out.println("Status " + response.statusCode());
            System.out.println("Body " + response.body());
        } else {
            System.out.println("FAILED");
        }
    }

    @Override
    public void sendRequestViaTitle(String title) throws URISyntaxException, IOException, InterruptedException {
        MovieInfoURIGeneratorbyTitle uri = new MovieInfoURIGeneratorbyTitle();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(uri.getByMovieTitle(title))
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            System.out.println("Status " + response.statusCode());
            System.out.println("Body " + response.body());
        } else {
            System.out.println("FAILED");
        }
    }


}

