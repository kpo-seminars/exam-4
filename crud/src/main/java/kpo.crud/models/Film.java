package kpo.crud.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Films")
@AllArgsConstructor
@NoArgsConstructor
public class Film {
    @Id
    @Column(name = "id", insertable = false)
    @GeneratedValue
    private Integer id;
    @Column
    private String genre;
    @Column
    private String name;
    @Column
    private Integer time;
    @Column
    private Integer date;
    @Column
    private Integer duration;
    @Column
    private Integer rating;
    @Column
    private Integer numberoftickets;

}
