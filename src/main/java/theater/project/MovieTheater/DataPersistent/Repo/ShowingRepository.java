package theater.project.MovieTheater.DataPersistent.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query("SELECT DISTINCT s.showingDate FROM Showing s WHERE s.movie.id = :movieId AND s.showingDate >= CURRENT_DATE ORDER BY s.showingDate")
    List<LocalDate> findAvailableDatesByMovieId(@Param("movieId") Long movieId);

    @Query("SELECT s.showingTime FROM Showing s WHERE s.movie.id = :movieId AND s.showingDate = :date")
    List<LocalTime> findBookedTimesByMovieIdAndDate(@Param("movieId") Long movieId, @Param("date") LocalDate date);
}
