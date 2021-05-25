package pl.sda;

import lombok.Data;
import pl.sda.uri.MovieInfoURIGenerator;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

@Data
public class APIClient {

    private MovieInfoURIGenerator uri;
    private Scanner scanner;

    public APIClient(MovieInfoURIGenerator uri, Scanner scanner) {
        this.uri = uri;
        this.scanner = scanner;
    }

    public void clientAPI(MovieInfoURIGenerator uri) throws IOException, InterruptedException, URISyntaxException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(scanner.nextLine()))
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200 || response.statusCode() == 201) {
            System.out.println("Status " + response.statusCode());
            System.out.println("Body " + response.body());
        } else {
            System.out.println("FAILED");
        }
    }
}