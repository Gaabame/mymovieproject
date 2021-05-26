package pl.sda.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Table (name = "mymovies")
//@SecondaryTable(name = "ratings")

public class Ratings {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;

    @JsonProperty("Source")
    private String source;

    @JsonProperty("Value")
    private String value;

}

