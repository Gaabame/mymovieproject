package pl.sda.parameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class IdParameter extends Parameter{
    private static final String PARAMETER_NAME = "i";
    private String id;

    public IdParameter(String id) {
        super(PARAMETER_NAME);
        this.id = id;
    }

    @Override
    public String valueAsString() {
        return id;
    }

}
