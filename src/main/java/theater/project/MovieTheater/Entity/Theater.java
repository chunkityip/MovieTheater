package theater.project.MovieTheater.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="theaters")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Theater {
}
