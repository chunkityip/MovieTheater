package theater.project.MovieTheater.DataPersistent.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import theater.project.MovieTheater.DataPersistent.Entity.Movie;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("SELECT m FROM Movie m")
    List<Movie> getAllMovies();

    @Query("SELECT m FROM Movie m JOIN Ticket t ON t.movie = m GROUP BY m ORDER BY COUNT(t) DESC")
    List<Movie> getTopSellingMovies();

    Movie getReferenceByTitle(String movieName);
}
