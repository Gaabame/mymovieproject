package pl.sda.query;

import lombok.NonNull;
import pl.sda.parameter.IdParameter;
import pl.sda.parameter.TitleParameter;

import java.util.ArrayList;

public class QueryByMovieId extends Query{

    @NonNull
    private IdParameter id;

    public QueryByMovieId() {
        parameters = new ArrayList<>();
    }

    public void addId(IdParameter id) {
        this.id = id;
        parameters.add(id);
    }
}