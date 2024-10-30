package theater.project.MovieTheater.API.DTO.Showing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import theater.project.MovieTheater.DataPersistent.Entity.Seat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddShowingDTO {
    private Long movieId;
    private LocalDate date;
    private LocalTime time;
    private List<Seat> seats = new ArrayList<>();
}
