package entity;

import jakarta.persistence.*;

@Entity
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;

    @ManyToOne
    @JoinColumn(name="movie_id")
    private Movie movie;

}
