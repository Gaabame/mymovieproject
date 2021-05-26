package pl.sda.service;

import pl.sda.uri.MovieInfoURIGeneratorbyTitle;
import pl.sda.uri.MovieInfoURIGeneratorbyId;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;

public interface AppService {
    void sendRequestViaId(String id) throws URISyntaxException, IOException, InterruptedException;
    void sendRequestViaTitle(String title) throws URISyntaxException, IOException, InterruptedException;


}
