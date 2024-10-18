package theater.project.MovieTheater.DataPersistent.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import theater.project.MovieTheater.DataPersistent.Entity.Theater;

import java.util.List;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {
    // Search theaters by name
    List<Theater> getByTheaterName(String name);

    // Fetch with movies
    @Query("SELECT t FROM Theater t LEFT JOIN FETCH t.movieList WHERE t.id = :theaterId")
    Theater getTheaterWithMovies(@Param("theaterId") Long theaterId);
}
