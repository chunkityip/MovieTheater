package theater.project.MovieTheater.API.DTO.Showing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import theater.project.MovieTheater.DataPersistent.Entity.Seat;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AllSeatStatusResponseDTO {
    private List<Seat> listOfSeats;
}
