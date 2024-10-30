package theater.project.MovieTheater.API.DTO.Showing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import theater.project.MovieTheater.DataPersistent.Entity.Seat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowingResponseDTO {
    private Long id;
    private Long movieId;
    private String movieTitle;
    private LocalDate showingDate;
    private LocalTime showingTime;
    private List<Seat> seats;
}