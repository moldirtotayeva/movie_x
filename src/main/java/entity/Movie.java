package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer year;
    private Double rating;
    private Integer count;

    @ManyToMany
    @JoinTable(name = "movie_to_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Genre> genres = new ArrayList<>();

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY, orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Actor> actors = new ArrayList<>();

    @OneToMany(mappedBy = "movie")
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    private List<Director> directors = new ArrayList<>();

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                ", count=" + count +
                '}';
    }
}
