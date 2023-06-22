package kpo.crud.requests;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmRequest {
    private String name;
    private Integer id;
    private Integer numberoftickets;
    private String genre;
    private Integer time;
    private Integer date;
    private Integer duration;
    private Integer rating;
}
