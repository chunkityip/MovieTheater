package theater.project.MovieTheater.DataPersistent.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import theater.project.MovieTheater.DataPersistent.Entity.Seat;
import theater.project.MovieTheater.DataPersistent.Enum.Status;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    Seat getSeatById(Long id);
    Seat getSeatBySeatNumber(String seatNumber);
    List<Seat> getSeatsByShowingId(Long showingId);

//    @Query("SELECT s FROM Seat s WHERE s.id = :seatId")
//    Seat getSeatById(@Param("seatId") Long id); // Corrected method signature
//
//    // Assuming seatNumber is unique, else change the method name to indicate it returns a list
//    @Query("SELECT s FROM Seat s WHERE s.seatNumber = :seatNumber")
//    Seat getSeatBySeatNumber(@Param("seatNumber") String seatNumber);

}
