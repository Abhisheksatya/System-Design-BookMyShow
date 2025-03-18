package in.scaler.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel {
    @Id
    private Long id;
    private String name;
    private Date releaseDate;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
}