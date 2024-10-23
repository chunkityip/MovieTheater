package theater.project.MovieTheater.DataPersistent.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import theater.project.MovieTheater.DataPersistent.Entity.Movie;
import theater.project.MovieTheater.DataPersistent.Entity.Showing;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ShowingRepository extends JpaRepository<Showing, Long> {
    Showing getShowingById(Long showingId);
    List<Showing> getShowingsByMovie(Movie movie);
    List<Showing> getShowingsByShowingDate(LocalDate date);
    List<Showing> getShowingsByShowingTime(LocalTime time);
}
