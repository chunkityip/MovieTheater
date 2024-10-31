package theater.project.MovieTheater.DataPersistent.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import theater.project.MovieTheater.DataPersistent.Enum.Status;

@Data
@Entity
@Table(name="seats")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String seatNumber;

    @Column(name="seat_status")
    private Status seatStatus;

    @ManyToOne
    @JoinColumn(name="showing_id")
    private Showing showing;
}
