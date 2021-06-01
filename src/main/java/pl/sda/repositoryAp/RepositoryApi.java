package pl.sda.repositoryAp;


import pl.sda.entity.MovieJson;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public interface RepositoryApi {

    HttpRequest sendRequestById(String id);
    HttpRequest sendRequestByTitle(String title);
    HttpResponse<String> getResponseByTitle(String title);
    HttpResponse<String> getResponseById(String id);
    MovieJson findByTitle(String title);
}
