package pl.sda.parameter;

public class IdParameter extends Parameter{
    private static final String PARAMETER_NAME = "i";
    private final String id;

    public IdParameter(String id) {
        super(PARAMETER_NAME);
        this.id = id;
    }

    @Override
    public String valueAsString() {
        return id;
    }

}
