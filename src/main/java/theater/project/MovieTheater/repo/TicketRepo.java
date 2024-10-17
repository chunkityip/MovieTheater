package theater.project.MovieTheater.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import theater.project.MovieTheater.Entity.Ticket;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Long> {
    // Q5.1 : How many ticket sales did we make for Start Wars
    // Base for the Movie Id
    List<Ticket> getTicketByMovieId(Long id);

    // Q5.3 Which day is our best average
    Ticket getBestAverageByDay(LocalDateTime timestamp);

}
