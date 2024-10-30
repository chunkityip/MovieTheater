package theater.project.MovieTheater.DataPersistent.Entity;

import lombok.*;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimeSlot {
    private String time;
    private boolean available;
}
