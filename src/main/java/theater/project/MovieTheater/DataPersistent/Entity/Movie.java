package theater.project.MovieTheater.DataPersistent.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "movies")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movie_title")
    private String title;

    @Column(name = "movie_description")
    private String description;
<<<<<<< HEAD

    @JoinColumn(name = "seat_id")
    @OneToMany
    private Seat[] availableSeats = new Seat[30];
=======
>>>>>>> f7a3f8a1139843218f6926ac4c9298ba12cfb9a0

    @Lob
    @Column(name = "cover_image")
    private byte[] coverImage;

    @Transient
    private String coverImageBase64;
}
