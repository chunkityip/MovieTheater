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

    /**
     * Maybe we should Join the Ticket table?
     * JOINTABLE
     */
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="ticket_id")
    private List<Ticket> tickets;


    /**
     * Maybe we should Join the Concession table?
     * JOINTABLE
     */
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="concession_id")
    private List<Concession> concessions;

    /*
    payment history for user account for all prior tickets bought and future.
     */
    // Once payment is complement , update to User
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="payment_time")
    private LocalDateTime paymentTime;
}
