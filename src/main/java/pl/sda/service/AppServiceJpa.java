package pl.sda.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.entity.MovieJson;
import pl.sda.factory.Factory;
import pl.sda.http.Request;
import pl.sda.http.Response;
import pl.sda.repository.JpaMovieJsonRepo;
import pl.sda.uri.MovieInfoURIGeneratorbyId;
import pl.sda.uri.MovieInfoURIGeneratorbyTitle;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class AppServiceJpa implements AppService {


    @Override
    public MovieJson getMovieById(String id) {
        Request request = new Request();
        HttpRequest requestById = request.getRequestById(id);
        Response response = new Response();
        if ( response.getResponseById(id).statusCode() == 200) {
            ObjectMapper mapper = new ObjectMapper();
            System.out.println(response.getResponseById(id).body());
            try {
                return mapper.readValue( response.getResponseById(id).body(), MovieJson.class);
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
        Request request = new Request();
        HttpRequest requestRequestByTitle = request.getRequestByTitle(title);
        Response response = new Response();
        if ( response.getResponseByTitle(title).statusCode() == 200) {
            ObjectMapper mapper = new ObjectMapper();
            System.out.println(response.getResponseByTitle(title).body());
            try {
                return mapper.readValue( response.getResponseByTitle(title).body(), MovieJson.class);
            } catch (JsonProcessingException e) {
                System.err.println(e.getMessage());
                return null;
            }
        } else {
            System.out.println("FAILED");
        }
        return null;
    }
//
//    @Override
//    public MovieJson getMovieByTitle(String title) {
//        MovieInfoURIGeneratorbyTitle uri = new MovieInfoURIGeneratorbyTitle();
//        URI byMovieTitle = null;
//        try {
//            byMovieTitle = uri.getByMovieTitle(title);
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//        HttpRequest request = null;
//        request = HttpRequest.newBuilder()
//                .GET()
//                .uri(byMovieTitle)
//                .build();
//        HttpClient client = HttpClient.newHttpClient();
//        HttpResponse<String> response = null;
//        try {
//            response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        } catch (IOException e) {
//            System.err.println(e.getMessage());
//        } catch (InterruptedException e) {
//            System.err.println(e.getMessage());
//        }
//        if (response.statusCode() == 200) {
//            ObjectMapper mapper = new ObjectMapper();
//            try {
//                return mapper.readValue(response.body(), MovieJson.class);
//            } catch (JsonProcessingException e) {
//                System.err.println(e.getMessage());
//                return null;
//            }
//        } else {
//            System.out.println("FAILED");
//        }
//        return null;
//    }

    @Override
    public void showActors(Scanner scanner) {
        SearchService service = new SearchService();
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
        SearchService service = new SearchService();
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
        SearchService service = new SearchService();
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
        SearchService service = new SearchService();
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
        SearchService service = new SearchService();
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
        SearchService service = new SearchService();
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
        SearchService service = new SearchService();
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
        SearchService service = new SearchService();
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
        SearchService service = new SearchService();
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
        SearchService service = new SearchService();
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
        SearchService service = new SearchService();
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
        SearchService service = new SearchService();
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
        SearchService service = new SearchService();
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
        SearchService service = new SearchService();
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
        SearchService service = new SearchService();
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
        SearchService service = new SearchService();
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

