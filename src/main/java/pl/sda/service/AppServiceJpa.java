package pl.sda.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.entity.MovieJson;
import pl.sda.repositoryAp.JpaRepositoryApi;
import java.net.http.HttpResponse;

public class AppServiceJpa implements AppService {

    JpaRepositoryApi repo = new JpaRepositoryApi();

    @Override
    public MovieJson getMovieById(String id) {
        repo.sendRequestById(id);
        HttpResponse<String> responseById = repo.getResponseById(id);
        if (responseById.statusCode() == 200) {
            ObjectMapper mapper = new ObjectMapper();
            System.out.println(responseById.body());
            try {
                return mapper.readValue(responseById.body(), MovieJson.class);
            } catch (JsonProcessingException e) {
                System.err.println(e.getMessage());
                return null;
            }
        } else {
            System.out.println("FAILED");
        }
        return null;
    }

    @Override
    public MovieJson getMovieByTitle(String title) {
        repo.sendRequestByTitle(title);
        HttpResponse<String> responseByTitle = repo.getResponseByTitle(title);
        if (responseByTitle.statusCode() == 200) {
            ObjectMapper mapper = new ObjectMapper();
            System.out.println(responseByTitle.body());
            try {
                return mapper.readValue(responseByTitle.body(), MovieJson.class);
            } catch (JsonProcessingException e) {
                System.err.println(e.getMessage());
                return null;
            }
        } else {
            System.out.println("FAILED");
        }
        return null;
    }

    @Override
    public void showActors(String title) {
        System.out.println(repo.findByTitle(title).getActors());
    }

    @Override
    public void showBoxOffice(String title) {
        System.out.println(repo.findByTitle(title).getBoxOffice());
    }

    @Override
    public void showImdbId(String title) {
        System.out.println(repo.findByTitle(title).getImdbID());
    }

    @Override
    public void showDirector(String title) {
        System.out.println(repo.findByTitle(title).getDirector());
    }
}