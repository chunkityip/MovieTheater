package theater.project.MovieTheater.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import theater.project.MovieTheater.Entity.Theater;

import java.util.List;
import java.util.Optional;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {
    // Search theaters by name
    List<Theater> getByNameContaining(String name);

    // Fetch with movies
    @Query("SELECT t FROM Theater t LEFT JOIN FETCH t.movieList WHERE t.id = :theaterId")
    Theater getTheaterWithMovies(@Param("theaterId") Long theaterId);
}
