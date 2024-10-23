package theater.project.MovieTheater.DataPersistent.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@Table(name="showings")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Showing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "movie_id")
    @ManyToOne
    private Movie movie;

    private LocalDate showingDate;
    private LocalTime showingTime;

//    @JoinColumn(name = "seat_id")
    @ManyToMany
    private List<Seat> seats;
}
