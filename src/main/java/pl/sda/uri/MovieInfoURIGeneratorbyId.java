package pl.sda.uri;

import pl.sda.parameter.IdParameter;
import pl.sda.parameter.TitleParameter;
import pl.sda.query.QueryByMovieId;
import pl.sda.query.QueryByMovieTitle;

import java.net.URI;
import java.net.URISyntaxException;

public class MovieInfoURIGeneratorbyId {

    private static final String HOST = "http://www.omdbapi.com/";
    // private static final String SOURCE = "/reviews/search.json";

    public URI getbyMovieId(String movieId) throws URISyntaxException {
        QueryByMovieId query = new QueryByMovieId();
        query.addId(new IdParameter(movieId));
        return new URI(HOST + query.asString());
    }
}
