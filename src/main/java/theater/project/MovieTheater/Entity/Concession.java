package theater.project.MovieTheater.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="concessions")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Concession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double price;
    private String itemName;

    @Column(name="purchase_time")
    private LocalDateTime purchaseTime;
}
