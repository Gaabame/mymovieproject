package pl.sda.query;

import lombok.NonNull;
import pl.sda.parameter.TitleParameter;

import java.util.ArrayList;

public class QueryByMovieTitle extends Query {
    @NonNull
    private TitleParameter title;

    public QueryByMovieTitle() {
        parameters = new ArrayList<>();
    }

    public void addTitle(TitleParameter title) {
        this.title = title;
        parameters.add(title);
    }
}