package pl.sda.http;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Response {

    private String title;
    private String id;

    public HttpResponse<String> getResponseByTitle(String title){
        Request request = new Request();
        HttpRequest requestByTitle = null;
        try {
            requestByTitle = request.getRequestByTitle(title);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = null;
        try {
            response = client.send(requestByTitle, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (response.statusCode() != 200) {
            System.out.println("FAILED");
        }
        return response;
    }

    public HttpResponse<String> getResponseById(String id) {
        Request request = new Request();
        HttpRequest requestById = null;
        try {
            requestById = request.getRequestById(id);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = null;
        try {
            response = client.send(requestById, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (response.statusCode() != 200) {
            System.out.println("FAILED");
        }
        return response;
    }
}
