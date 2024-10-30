package theater.project.MovieTheater.API.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import theater.project.MovieTheater.API.DTO.Seat.SeatSelectionRequestDTO;
import theater.project.MovieTheater.API.DTO.Seat.SeatSelectionResponseDTO;
import theater.project.MovieTheater.API.DTO.Showing.*;
import theater.project.MovieTheater.DataPersistent.Entity.Seat;
import theater.project.MovieTheater.DataPersistent.Entity.Showing;
import theater.project.MovieTheater.DataPersistent.Repo.MovieRepository;
import theater.project.MovieTheater.Service.SeatService;
import theater.project.MovieTheater.Service.ShowingService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movie/{movie_id}/showings")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ShowingController {

    private final ShowingService showingService;
    private final SeatService seatService;
    private final MovieRepository movieRepository;


//    @PostMapping("/add_new")
//    public AddShowingDTO addNewShowing(@PathVariable("movie_id") Long movieId,
//                                       @RequestBody AddShowingDTO requestDTO) {
//        // Verify that movieId from path matches requestDTO.getMovieId()
//        if (!movieId.equals(requestDTO.getMovieId())) {
//            throw new IllegalArgumentException("Movie ID in path does not match movie ID in request body");
//        }
//
//        Showing showingToAdd = Showing.builder()
//                .movie(movieRepository.getReferenceById(movieId)) // Use movieId from path
//                .showingDate(requestDTO.getDate())
//                .showingTime(requestDTO.getTime())
//                .seats(requestDTO.getSeats())
//                .build();
//
//        Showing addedShowing = showingService.addNewShowing(showingToAdd);
//
//        return AddShowingDTO.builder()
//                .movieId(addedShowing.getMovie().getId())
//                .date(addedShowing.getShowingDate())
//                .time(addedShowing.getShowingTime())
//                .seats(addedShowing.getSeats())
//                .build();
//    }


    @GetMapping
    public List<LocalDate> getShowingDatesByMovieId(@PathVariable Long movieId){
        List<Showing> showingsByMovieId = showingService.getShowingsByMovieId(movieId);
        List<LocalDate> datesToShowByMovie = new ArrayList<>();
        for (Showing showing : showingsByMovieId){
            if (showing.getShowingDate().isEqual(LocalDate.now()) || showing.getShowingDate().isAfter(LocalDate.now())){
                datesToShowByMovie.add(showing.getShowingDate());
            }
        }
        return datesToShowByMovie;
    }

    @GetMapping("/{showing_date}")
    public List<LocalTime> getShowingTimesByMovieIdAndDate(@PathVariable Long movieId, @PathVariable LocalDate showingDate){
        List<Showing> showingsByMovieIdAndDate = showingService.getShowingsByMovieAndDate(movieId, showingDate);
        List<LocalTime> timesToShowByMovieAndDate = new ArrayList<>();
        for (Showing showing : showingsByMovieIdAndDate){
            if (showing.getShowingTime().isAfter(LocalTime.now())){
                timesToShowByMovieAndDate.add(showing.getShowingTime());
            }
        }
        return timesToShowByMovieAndDate;
    }

    @PostMapping("/{showing_date}/{showing_time}")
    public Long getShowingIdByMovieWithDateAndTime(@PathVariable Long movieId, @PathVariable LocalDate date, @PathVariable LocalTime time){

        ShowingSelectionResponseDTO responseDTO = showingService.getShowingByMovieWithDateAndTime(movieId, date, time);
        return responseDTO.getShowingId();
    }

    @GetMapping("/{showing_id}/allSeats")
    public AllSeatStatusResponseDTO getAllSeatStatus(@PathVariable Long showingId){
        return showingService.getAllSeatsForShowing(showingId);
    }

    @PostMapping("/{showing_id}/allSeats")
    public SeatSelectionResponseDTO seatSelection(@RequestBody SeatSelectionRequestDTO requestDTO){
        List<Seat> listOfSelectedSeats = requestDTO.getSelectedSeat();
        List<Long> listOfSelectedSeatIds = new ArrayList<>();
        for(Seat seat : listOfSelectedSeats){
            seatService.selectSeat(seat.getId());
            listOfSelectedSeatIds.add(seat.getId());
        }
        return new SeatSelectionResponseDTO(listOfSelectedSeatIds);
    }

    // CK part
    @GetMapping("/available-dates")
    public ResponseEntity<List<String>> getAvailableDates(@PathVariable("movie_id") Long movieId) {
        return ResponseEntity.ok(showingService.getAvailableDates(movieId));
    }

    @GetMapping("/available-times")
    public ResponseEntity<List<TimeSlotDTO>> getAvailableTimeSlots(
            @PathVariable("movie_id") Long movieId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(showingService.getAvailableTimeSlots(movieId, date));
    }

    @GetMapping("/availability")
    public ResponseEntity<ShowingAvailabilityResponseDTO> getShowingAvailability(
            @PathVariable("movie_id") Long movieId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

        ShowingAvailabilityResponseDTO response = ShowingAvailabilityResponseDTO.builder()
                .movieId(movieId)
                .availableDates(showingService.getAvailableDates(movieId))
                .availableTimeSlots(date != null ?
                        showingService.getAvailableTimeSlots(movieId, date) :
                        null)
                .build();

        return ResponseEntity.ok(response);
    }

    @PostMapping("/add_new")
    public ResponseEntity<ShowingResponseDTO> addNewShowing(
            @PathVariable("movie_id") Long movieId,
            @RequestBody AddShowingDTO requestDTO) {

        if (!movieId.equals(requestDTO.getMovieId())) {
            throw new IllegalArgumentException("Movie ID in path does not match movie ID in request body");
        }

        Showing showingToAdd = Showing.builder()
                .movie(movieRepository.getReferenceById(movieId))
                .showingDate(requestDTO.getDate())
                .showingTime(requestDTO.getTime())
                .seats(requestDTO.getSeats())
                .build();

        Showing addedShowing = showingService.addNewShowing(showingToAdd);

        return ResponseEntity.ok(ShowingResponseDTO.builder()
                .id(addedShowing.getId())
                .movieId(addedShowing.getMovie().getId())
                .movieTitle(addedShowing.getMovie().getTitle())
                .showingDate(addedShowing.getShowingDate())
                .showingTime(addedShowing.getShowingTime())
                .seats(addedShowing.getSeats())
                .build());
    }


}
