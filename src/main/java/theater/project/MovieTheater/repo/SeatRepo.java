package theater.project.MovieTheater.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import theater.project.MovieTheater.Entity.Seat;

import java.util.List;

@Repository
public interface SeatRepo extends JpaRepository<Seat, Long> {

    List<Seat> getAllSeats();
    Seat getSeatBySeatId(Long id);
    Seat getSeatBySeatNumber(String seatNumber);

}
