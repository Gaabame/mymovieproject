package pl.sda.query;

//TEST
import pl.sda.parameter.Parameter;

import java.util.List;
import java.util.Objects;

public abstract class Query {

    private static final String QUESTION_MARK = "?";
    public static final String AND = "&";
    private static final String KEY = "apikey=c26f0a5a";
    protected List<Parameter> parameters;

    public String asString() {
        return QUESTION_MARK +KEY +AND + parameters.stream()
                .filter(Objects::nonNull)
                .map(a -> a.asString())
                .reduce("", (a, b) -> a.isEmpty() ? a + b : a + AND + b);
    }
}