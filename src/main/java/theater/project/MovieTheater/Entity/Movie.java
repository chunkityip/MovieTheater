package theater.project.MovieTheater.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @JoinColumn(name = "seat_id")
    @OneToMany
    private List<Seat> availableSeats;

    /**
     * Should the Movie associated with showings in a Theater ?
     */

    // Store image as Movie cover?
    /*
    @Lob
    @Column(name = "cover_image")
    private byte[] coverImage; // Store image as a binary array
     */
}
