package theater.project.MovieTheater.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

/*
Payments will account for each movie sale + concessions for that date
 */
@Data
@Entity
@Table(name="payments")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="total_balance")
    private double totalBalance;

    @OneToMany
    @JoinColumn(name="ticket_id")
    private List<Ticket> tickets;

    @OneToMany
    @JoinColumn(name="concession_id")
    private List<Concession> concessions;

    /*
    payment history for user account for all prior tickets bought and future.
     */
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="payment_time")
    private LocalDateTime paymentTime;
}
