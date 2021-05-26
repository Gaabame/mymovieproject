package pl.sda.service;

import pl.sda.entity.MovieJson;
import pl.sda.uri.MovieInfoURIGeneratorbyId;
import pl.sda.uri.MovieInfoURIGeneratorbyTitle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class AppServiceJpa implements AppService {

    @Override
    public void sendRequestViaId(String id) {
        MovieInfoURIGeneratorbyId uri = new MovieInfoURIGeneratorbyId();
        HttpRequest request = null;
        try {
            request = HttpRequest.newBuilder()
                    .GET()
                    .uri(uri.getbyMovieId(id))
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (response.statusCode() == 200) {
            System.out.println("Status " + response.statusCode());
            System.out.println("Body " + response.body());
        } else {
            System.out.println("FAILED");
        }
    }

    @Override
    public void sendRequestViaTitle(String title) {
        MovieInfoURIGeneratorbyTitle uri = new MovieInfoURIGeneratorbyTitle();
        HttpRequest request = null;
        try {
            request = HttpRequest.newBuilder()
                    .GET()
                    .uri(uri.getByMovieTitle(title))
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (response.statusCode() == 200) {
            System.out.println("Status " + response.statusCode());
            System.out.println("Body " + response.body());
        } else {
            System.out.println("FAILED");
        }
    }

    @Override
    public void showActors(Scanner scanner){
            JsonToJavaService service = new JsonToJavaService();
        MovieJson movieJson = null;
        try {
            movieJson = service.searchBy(scanner);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(movieJson.getActors());
    }

    @Override
    public void showYear(Scanner scanner) {
        JsonToJavaService service = new JsonToJavaService();
        MovieJson movieJson = null;
        try {
            movieJson = service.searchBy(scanner);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(movieJson.getYear());
    }

    @Override
    public void showAwards(Scanner scanner) {
        JsonToJavaService service = new JsonToJavaService();
        MovieJson movieJson = null;
        try {
            movieJson = service.searchBy(scanner);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(movieJson.getAwards());
    }

    @Override
    public void showDirector(Scanner scanner) {
        JsonToJavaService service = new JsonToJavaService();
        MovieJson movieJson = null;
        try {
            movieJson = service.searchBy(scanner);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(movieJson.getDirector());
    }

    @Override
    public void showWriter(Scanner scanner) {
        JsonToJavaService service = new JsonToJavaService();
        MovieJson movieJson = null;
        try {
            movieJson = service.searchBy(scanner);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(movieJson.getWriter());
    }

    @Override
    public void getCountry(Scanner scanner) {
        JsonToJavaService service = new JsonToJavaService();
        MovieJson movieJson = null;
        try {
            movieJson = service.searchBy(scanner);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(movieJson.getCountry());
    }

    @Override
    public void showImdbRating(Scanner scanner) {
        JsonToJavaService service = new JsonToJavaService();
        MovieJson movieJson = null;
        try {
            movieJson = service.searchBy(scanner);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(movieJson.getImdbRating());
    }

    @Override
    public void showBoxOffice(Scanner scanner) {
        JsonToJavaService service = new JsonToJavaService();
        MovieJson movieJson = null;
        try {
            movieJson = service.searchBy(scanner);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(movieJson.getBoxOffice());
    }

    @Override
    public void showGenre(Scanner scanner) {
        JsonToJavaService service = new JsonToJavaService();
        MovieJson movieJson = null;
        try {
            movieJson = service.searchBy(scanner);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(movieJson.getGenre());
    }

    @Override
    public void showImdbVotes(Scanner scanner) {
        JsonToJavaService service = new JsonToJavaService();
        MovieJson movieJson = null;
        try {
            movieJson = service.searchBy(scanner);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(movieJson.getImdbVotes());
    }

    @Override
    public void showLanguage(Scanner scanner) {
        JsonToJavaService service = new JsonToJavaService();
        MovieJson movieJson = null;
        try {
            movieJson = service.searchBy(scanner);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(movieJson.getLanguage());
    }

    @Override
    public void showPlot(Scanner scanner) {
        JsonToJavaService service = new JsonToJavaService();
        MovieJson movieJson = null;
        try {
            movieJson = service.searchBy(scanner);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(movieJson.getPlot());
    }

    @Override
    public void showWebsite(Scanner scanner) {
        JsonToJavaService service = new JsonToJavaService();
        MovieJson movieJson = null;
        try {
            movieJson = service.searchBy(scanner);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(movieJson.getWebsite());
    }

    @Override
    public void showImdbId(Scanner scanner) {
        JsonToJavaService service = new JsonToJavaService();
        MovieJson movieJson = null;
        try {
            movieJson = service.searchBy(scanner);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(movieJson.getImdbID());
    }

    @Override
    public void showMovieDuration(Scanner scanner) {
        JsonToJavaService service = new JsonToJavaService();
        MovieJson movieJson = null;
        try {
            movieJson = service.searchBy(scanner);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(movieJson.getRuntime());
    }

    @Override
    public void showReleasedYear(Scanner scanner) {
        JsonToJavaService service = new JsonToJavaService();
        MovieJson movieJson = null;
        try {
            movieJson = service.searchBy(scanner);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(movieJson.getReleased());
    }
}

