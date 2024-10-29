package theater.project.MovieTheater.API.DTO.Showing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowingSelectionResponseDTO {
    private Long movieId;
    private LocalDate date;
    private LocalTime time;
    private Long showingId;
}
