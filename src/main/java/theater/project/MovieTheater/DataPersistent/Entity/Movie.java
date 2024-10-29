package theater.project.MovieTheater.DataPersistent.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="movies")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String description;
    @JoinColumn(name = "seat_id")
    @OneToMany
    private Seat[] availableSeats = new Seat[30];

    @Column(name = "cover_image")
    private String coverImage;

//    private String status;

}
