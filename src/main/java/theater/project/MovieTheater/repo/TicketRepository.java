package theater.project.MovieTheater.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import theater.project.MovieTheater.Entity.Ticket;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> getTicketsByMovieId(Long id);

    @Query("SELECT t FROM Ticket t WHERE t.timestamp = (SELECT MAX(t2.timestamp) FROM Ticket t2 GROUP BY DAY(t2.timestamp))")
    Ticket getBestAverageByDay();
    @Query("SELECT COUNT(t) FROM Ticket t WHERE t.movie.id = :movieId")
    long getCountOfTicketsByMovieId(@Param("movieId") Long movieId);

//    @Query("SELECT t FROM Ticket t WHERE t.timestamp BETWEEN :start AND :end")
//    List<Ticket> getTicketsBetweenDates(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

}
