package theater.project.MovieTheater.DataPersistent.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import theater.project.MovieTheater.DataPersistent.Entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u JOIN u.payments p JOIN p.tickets t WHERE t.id = :ticketId")
    Optional<User> getUserByTicketId(@Param("ticketId") Long id);

    Optional<User> getUserById(Long id);

    Optional<User> getUserByName(String name);

    Long getUserId();
}
