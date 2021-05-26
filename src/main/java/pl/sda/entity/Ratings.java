package pl.sda.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;

@Data
public class Ratings {

    @JsonProperty("Source")
    private String source;

    @JsonProperty("Value")
    private String value;

}

