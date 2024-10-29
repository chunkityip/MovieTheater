package theater.project.MovieTheater.API.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import theater.project.MovieTheater.API.DTO.Seat.SeatSelectionRequestDTO;
import theater.project.MovieTheater.API.DTO.Seat.SeatSelectionResponseDTO;
import theater.project.MovieTheater.API.DTO.Showing.AllSeatStatusRequestDTO;
import theater.project.MovieTheater.API.DTO.Showing.AllSeatStatusResponseDTO;
import theater.project.MovieTheater.DataPersistent.Entity.Seat;
import theater.project.MovieTheater.Service.SeatService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/showings/{showing_id}/allSeats")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class SeatController {

    private final SeatService seatService;

    @PostMapping()
    public SeatSelectionResponseDTO seatSelection(@RequestBody SeatSelectionRequestDTO requestDTO){
        List<Seat> selectedSeats = requestDTO.getSelectedSeat();
        List<Long> selectedSeatIds = new ArrayList<>();
        for (Seat seat : selectedSeats){
            selectedSeatIds.add(seat.getId());
        }
        seatService.selectSeatsInBulkBySeatIds(selectedSeatIds);
        return new SeatSelectionResponseDTO(selectedSeatIds);
    }

}
