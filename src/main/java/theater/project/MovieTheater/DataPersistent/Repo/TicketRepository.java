package theater.project.MovieTheater.DataPersistent.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import theater.project.MovieTheater.DataPersistent.Entity.Movie;
import theater.project.MovieTheater.DataPersistent.Entity.Seat;
import theater.project.MovieTheater.DataPersistent.Entity.Ticket;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> getTicketsByMovie(Movie movie);
    List<Ticket> getTicketsByDate(LocalDate date);
    List<Ticket> getTicketsByTime(LocalTime time);
    List<Ticket> getTicketsBySeat(Seat seat);


//    @Query("SELECT t FROM Ticket t WHERE t.timestamp = (SELECT MAX(t2.timestamp) FROM Ticket t2 GROUP BY DAY(t2.timestamp))")
//    Ticket getBestAverageByDay();

    @Query("SELECT COUNT(t) FROM Ticket t WHERE t.movie.id = :movieId")
    Long getCountOfTicketsByMovieId(@Param("movieId") Long movieId);

    // Year , Month , day , three query
//    @Query("SELECT t FROM Ticket t WHERE t.timestamp BETWEEN :start AND :end")
//    List<Ticket> getTicketsBetweenDates(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

}
