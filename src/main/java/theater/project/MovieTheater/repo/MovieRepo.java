package theater.project.MovieTheater.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import theater.project.MovieTheater.Entity.Movie;

import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {
    List<Movie> getAllMovie();

    Movie getMovieByMovieId(Long id);

}
