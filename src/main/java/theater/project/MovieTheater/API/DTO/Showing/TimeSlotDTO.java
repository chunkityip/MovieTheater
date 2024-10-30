package theater.project.MovieTheater.API.DTO.Showing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimeSlotDTO {
    private String time; // e.g., "08:50:55"
    private boolean available;
}
