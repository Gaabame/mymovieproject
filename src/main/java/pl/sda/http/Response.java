package pl.sda.http;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Response {

    private String title;
    private String id;

    public HttpResponse<String> getResponseByTitle(String title) throws URISyntaxException, IOException, InterruptedException {
        Request request = new Request();
        HttpRequest requestByTitle = request.getRequestByTitle(title);
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(requestByTitle, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            System.out.println("FAILED");
        }
        return response;
    }

    public HttpResponse<String> getResponseById(String id) throws URISyntaxException, IOException, InterruptedException {
        Request request = new Request();
        HttpRequest requestById = request.getRequestById(id);
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(requestById, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            System.out.println("FAILED");
        }
        return response;
    }
}
