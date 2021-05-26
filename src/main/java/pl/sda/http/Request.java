package pl.sda.http;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.uri.MovieInfoURIGeneratorbyId;
import pl.sda.uri.MovieInfoURIGeneratorbyTitle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
@Data
public class Request {

    private String id;
    private String title;

    public HttpRequest getRequestById(String id) throws URISyntaxException {
        MovieInfoURIGeneratorbyId uri = new MovieInfoURIGeneratorbyId();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(uri.getbyMovieId(id))
                .build();
        return request;
    }

    public HttpRequest getRequestByTitle(String title) throws URISyntaxException {
        MovieInfoURIGeneratorbyTitle uri = new MovieInfoURIGeneratorbyTitle();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(uri.getByMovieTitle(title))
                .build();
        return request;
    }
}

