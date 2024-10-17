package theater.project.MovieTheater.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="tickets")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name="movie_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(nullable = false)
    private double price;

    @JoinColumn(name="seat_id")
    @OneToOne
    private Seat seat;

}
