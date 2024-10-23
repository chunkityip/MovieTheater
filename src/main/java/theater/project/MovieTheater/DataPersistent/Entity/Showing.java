package theater.project.MovieTheater.DataPersistent.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

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

    @JoinColumn(name = "id")
    @ManyToOne
    private Movie movie;

    private LocalDate showingDate;
    private LocalTime showingTime;

    @JoinColumn(name = "id")
    @OneToMany
    private Seat[] listOfSeats = new Seat[30];
}
