package theater.project.MovieTheater.DataPersistent.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import theater.project.MovieTheater.DataPersistent.Entity.Concession;

import java.util.List;

@Repository
public interface ConcessionRepository extends JpaRepository<Concession, Long> {

    // Search Concessions by name
//    @Query("SELECT c FROM Concession c WHERE c.itemName LIKE %:name%")
    List<Concession> getConcessionsByItemName(@Param("name") String name);
}
