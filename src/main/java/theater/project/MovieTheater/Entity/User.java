package theater.project.MovieTheater.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import theater.project.MovieTheater.Enum.UserRole;

import java.util.List;

@Data
@Entity
@Table(name="users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = true)
    private String name;

    @Column(nullable=false)
    private String email;

    @Column(name="user_role")
    private UserRole userRole;

    @Column(name="payments")
    @OneToMany
    private List<Payment> payments;

}
