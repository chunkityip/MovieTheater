package theater.project.MovieTheater.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import theater.project.MovieTheater.Entity.User;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    
    // As a guest , user the ticker id to search the info
    // One User for one ticker id
    User findUserByTicketId(Long id);

    // search user by user id
    User findUserByUserId(Long id);



    
}
