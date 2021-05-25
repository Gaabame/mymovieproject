package pl.sda.parameter;

public class TitleParameter extends Parameter {
    private static final String PARAMETER_NAME = "t";
    private String movieTitle;
    public TitleParameter(String movieTitle) {
        super(PARAMETER_NAME);
        this.movieTitle = movieTitle;
    }
    @Override
    public String valueAsString() {
        return movieTitle.replace(" ","+");
    }
}