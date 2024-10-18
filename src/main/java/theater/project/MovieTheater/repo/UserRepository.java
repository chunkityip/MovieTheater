package theater.project.MovieTheater.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import theater.project.MovieTheater.Entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //@Query("SELECT u FROM User u JOIN u.payments p JOIN p.tickets t WHERE t.id = :ticketId")
    User getUserByTicketId(@Param("ticketId") Long id);

    User getUserById(Long id);
}
