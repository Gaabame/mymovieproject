package pl.sda.parameter;

public class IdParameter extends Parameter{
    private static final String PARAMETER_NAME = "i";
    private String id;

    protected IdParameter(String id) {
        super(PARAMETER_NAME);
        this.id = id;
    }

    @Override
    public String valueAsString() {
        return id;
    }
}
