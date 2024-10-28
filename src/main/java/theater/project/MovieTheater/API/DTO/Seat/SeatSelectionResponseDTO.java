package theater.project.MovieTheater.API.DTO.Seat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatSelectionResponseDTO {
    private List<Long> selectedSeatIds;
}
