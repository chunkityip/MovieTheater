package theater.project.MovieTheater.API.DTO.Seat;


import lombok.Data;
import theater.project.MovieTheater.DataPersistent.Entity.Seat;

import java.util.List;

@Data
public class SeatSelectionRequestDTO {
    private List<Seat> selectedSeat;
}
