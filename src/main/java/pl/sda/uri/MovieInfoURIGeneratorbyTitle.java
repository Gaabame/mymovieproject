package pl.sda.uri;

//TEST
import pl.sda.parameter.TitleParameter;
import pl.sda.query.QueryByMovieTitle;

import java.net.URI;
import java.net.URISyntaxException;

public class MovieInfoURIGeneratorbyTitle {
    private static final String HOST = "http://www.omdbapi.com/";
    // private static final String SOURCE = "/reviews/search.json";

    public URI getByMovieTitle(String movieTitle) throws URISyntaxException {
        QueryByMovieTitle query = new QueryByMovieTitle();
        query.addTitle(new TitleParameter(movieTitle));
        return new URI(HOST + query.asString());
    }
}