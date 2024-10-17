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
     * joinColumns: Assign the column of third table related to entity itself.
     * inverseJoinColumns: Assign the column of third table related to associated entity.
     */
    @OneToMany(fetch = FetchType.LAZY)
    //@JoinColumn(name="ticket_id")
    @JoinTable(
            name ="payment_tickets",
            joinColumns = @JoinColumn(name = "payment_id"),
            inverseJoinColumns = @JoinColumn(name = "ticket_id")
    )
    private List<Ticket> tickets;


    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name ="payment_concessions",
            joinColumns = @JoinColumn(name = "payment_id"),
            inverseJoinColumns = @JoinColumn(name = "concession_id")
    )
    //@JoinColumn(name="concession_id")
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
