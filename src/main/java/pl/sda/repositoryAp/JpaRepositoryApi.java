package pl.sda.repositoryAp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.entity.MovieJson;
import pl.sda.http.ApiClientResponse;
import pl.sda.uri.MovieInfoURIGeneratorbyId;
import pl.sda.uri.MovieInfoURIGeneratorbyTitle;

import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JpaRepositoryApi implements RepositoryApi {

    @Override
    public HttpRequest sendRequestById(String id) {
        MovieInfoURIGeneratorbyId uri = new MovieInfoURIGeneratorbyId();
        try {
            return HttpRequest.newBuilder()
                    .GET()
                    .uri(uri.getbyMovieId(id))
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public HttpRequest sendRequestByTitle(String title) {
        MovieInfoURIGeneratorbyTitle uri = new MovieInfoURIGeneratorbyTitle();
        try {
            return HttpRequest.newBuilder()
                    .GET()
                    .uri(uri.getByMovieTitle(title))
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public HttpResponse getResponseByTitle(String title) {
        HttpRequest request = sendRequestByTitle(title);
        ApiClientResponse response = new ApiClientResponse();
        return response.getResponse(request);
    }

    @Override
    public HttpResponse getResponseById(String id) {
        HttpRequest request = sendRequestById(id);
        ApiClientResponse response = new ApiClientResponse();
        return response.getResponse(request);
    }

    @Override
    public MovieJson findByTitle(String title) {
        ObjectMapper mapper = new ObjectMapper();
        String body = (String) getResponseByTitle(title).body();
        try {
            return mapper.readValue(body, MovieJson.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
