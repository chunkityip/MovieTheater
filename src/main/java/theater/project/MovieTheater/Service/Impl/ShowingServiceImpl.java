package theater.project.MovieTheater.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import theater.project.MovieTheater.API.DTO.Showing.AllSeatStatusResponseDTO;
import theater.project.MovieTheater.API.DTO.Showing.ShowingSelectionResponseDTO;
import theater.project.MovieTheater.DataPersistent.Entity.Seat;
import theater.project.MovieTheater.DataPersistent.Entity.Showing;
import theater.project.MovieTheater.DataPersistent.Enum.Status;
import theater.project.MovieTheater.DataPersistent.Repo.MovieRepository;
import theater.project.MovieTheater.DataPersistent.Repo.SeatRepository;
import theater.project.MovieTheater.DataPersistent.Repo.ShowingRepository;
import theater.project.MovieTheater.Exception.ShowingNotFoundException;
import theater.project.MovieTheater.Service.ShowingService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowingServiceImpl implements ShowingService {

    private final ShowingRepository showingRepository;
    private final MovieRepository movieRepository;
    private final SeatRepository seatRepository;

    // Define standard showing times
    private static final List<LocalTime> STANDARD_SHOWING_TIMES = List.of(
            LocalTime.of(10, 0),  // 10:00 AM
            LocalTime.of(12, 0),  // 12:00 PM
            LocalTime.of(14, 0),  // 2:00 PM
            LocalTime.of(16, 0),  // 4:00 PM
            LocalTime.of(18, 0),  // 6:00 PM
            LocalTime.of(20, 0)   // 8:00 PM
    );

    @Override
    public Showing getShowingById(Long showingId) {
        Showing showing = showingRepository.getShowingById(showingId);
        if (showing == null){
            throw new ShowingNotFoundException("Showing Not Found by Showing Id: " + showingId);
        } else return showing;
    }

    @Override
    public List<Showing> getAllShowings() {
        return showingRepository.findAll();
    }

    @Override
    public List<Showing> getShowingsByDate(LocalDate date) {
        return showingRepository.getShowingsByShowingDate(date);
    }

    @Override
    public List<Showing> getShowingsByDateAndTime(LocalDate date, LocalTime time) {
        List<Showing> listOfShowingsByDate = new ArrayList<>();
        List<Showing> listOfShowingsByDateAndTime = new ArrayList<>();

        listOfShowingsByDate.addAll(showingRepository.getShowingsByShowingDate(date));
        for (Showing showing : listOfShowingsByDate){
            if (showing.getShowingTime().equals(time)){
                listOfShowingsByDateAndTime.add(showing);
            }
        }
        return listOfShowingsByDateAndTime;
    }

    @Override
    public List<Showing> getShowingsByMovieId(Long movieId) {
        return showingRepository.getShowingsByMovie(movieRepository.getReferenceById(movieId));
    }

    @Override
    public List<Showing> getShowingsByMovieAndDate(Long movieId, LocalDate date) {
        List<Showing> showingsByMovieAndDate = new ArrayList<>();

        List<Showing> showingsByMovie = showingRepository.getShowingsByMovie(movieRepository.getReferenceById(movieId));
        for (Showing showing : showingsByMovie){
            if(showing.getShowingDate().equals(date)){
                showingsByMovieAndDate.add(showing);
            }
        }
        return showingsByMovieAndDate;

    }

    @Override
    public List<Showing> getShowingsByMovieIdAndTime(Long movieId, LocalTime time) {
        List<Showing> showingsByMovieAndTime = new ArrayList<>();

        List<Showing> showingsByMovie = showingRepository.getShowingsByMovie(movieRepository.getReferenceById(movieId));
        for (Showing showing : showingsByMovie){
            if(showing.getShowingTime().equals(time)){
                showingsByMovieAndTime.add(showing);
            }
        }
        return showingsByMovieAndTime;
    }

    @Override
    public ShowingSelectionResponseDTO getShowingByMovieWithDateAndTime(Long movieId, LocalDate date, LocalTime time) {
        Showing targetShowing = null;

        List<Showing> showingsByMovie = showingRepository.getShowingsByMovie(movieRepository.getReferenceById(movieId));
        for (Showing showing : showingsByMovie){
            if(showing.getShowingDate().isEqual(date) && showing.getShowingTime().equals(time)){
                targetShowing = showing;
            }
        }
        return new ShowingSelectionResponseDTO(targetShowing.getMovie().getId(), targetShowing.getShowingDate(), targetShowing.getShowingTime(), targetShowing.getId());

    }



    @Override
    public void deleteShowing(Long showingId) {
        showingRepository.deleteById(showingId);
    }

    @Override
    public List<Showing> addMultipleNewShowings(List<Showing> showings) {
        return showingRepository.saveAll(showings);
    }

    @Override
    public void removeMultipleShowings(List<Showing> showings) {
        showingRepository.deleteAll(showings);
    }

    @Override
    public void removeAllShowingsByMovieId(Long movieId) {
        List<Showing> showingsByMovie = showingRepository.getShowingsByMovie(movieRepository.getReferenceById(movieId));
        showingRepository.deleteAll(showingsByMovie);
    }

    @Override
    public void removeAllShowingsByMovieName(String movieName) {
        List<Showing> showingsByMovie = showingRepository.getShowingsByMovie(movieRepository.getReferenceByTitle(movieName));
        showingRepository.deleteAll(showingsByMovie);
    }

    @Override
    public void removeAllShowingsByDate(LocalDate date) {
        List<Showing> showingsByDate = showingRepository.getShowingsByShowingDate(date);
        showingRepository.deleteAll(showingsByDate);
    }

    @Override
    public boolean showingExistsByShowingId(Long showingId) {
        return showingRepository.existsById(showingId);
    }

    @Override
    public boolean showingExistsByMovieId(Long movieId) {
        List<Showing> listOfShowing = getShowingsByMovieId(movieId);
        return !listOfShowing.isEmpty();
    }

    @Override
    public boolean showingExistsByMovieName(String movieName) {
        List<Showing> showingsByMovie = showingRepository.getShowingsByMovie(movieRepository.getReferenceByTitle(movieName));
        return !showingsByMovie.isEmpty();
    }

    @Override
    public int getNumOfAvailableSeats(Long showingId) {
        List<Seat> availableSeats = new ArrayList<>();
        for (Seat seat : seatRepository.getSeatsByShowingId(showingId)){
            if(seat.getSeatStatus().equals(Status.AVAILABLE)){
                availableSeats.add(seat);
            }
        }
        return availableSeats.size();
    }

    @Override
    public int getNumOfOccupiedSeats(Long showingId) {
        List<Seat> occupiedSeats = new ArrayList<>();
        for (Seat seat : seatRepository.getSeatsByShowingId(showingId)){
            if(seat.getSeatStatus().equals(Status.OCCUPIED)){
                occupiedSeats.add(seat);
            }
        }
        return occupiedSeats.size();
    }

    @Override
    public int getNumOfDisabledSeats(Long showingId) {
        List<Seat> disabledSeats = new ArrayList<>();
        for (Seat seat : seatRepository.getSeatsByShowingId(showingId)){
            if(seat.getSeatStatus().equals(Status.DISABLED)){
                disabledSeats.add(seat);
            }
        }
        return disabledSeats.size();
    }

    @Override
    public AllSeatStatusResponseDTO getAllSeatsForShowing(Long showingId) {
        List<Seat> allSeats = seatRepository.getSeatsByShowingId(showingId);
        return new AllSeatStatusResponseDTO(allSeats);
    }

    @Override
    public List<Seat> getAvailableSeatsForShowing(Long showingId) {
        List<Seat> availableSeats = new ArrayList<>();
        for (Seat seat : seatRepository.getSeatsByShowingId(showingId)){
            if(seat.getSeatStatus().equals(Status.AVAILABLE)){
                availableSeats.add(seat);
            }
        }
        return availableSeats;
    }

    @Override
    public List<Seat> getDisabledSeatsForShowing(Long showingId) {
        List<Seat> disabledSeats = new ArrayList<>();
        for (Seat seat : seatRepository.getSeatsByShowingId(showingId)){
            if(seat.getSeatStatus().equals(Status.DISABLED)){
                disabledSeats.add(seat);
            }
        }
        return disabledSeats;
    }

    @Override
    public List<Seat> getOccupiedSeatsForShowing(Long showingId) {
        List<Seat> occupiedSeats = new ArrayList<>();
        for (Seat seat : seatRepository.getSeatsByShowingId(showingId)){
            if(seat.getSeatStatus().equals(Status.OCCUPIED)){
                occupiedSeats.add(seat);
            }
        }
        return occupiedSeats;
    }

    @Override
    public List<Seat> getSelectedSeatsForShowing(Long showingId) {
        List<Seat> selectedSeats = new ArrayList<>();
        for (Seat seat : seatRepository.getSeatsByShowingId(showingId)){
            if(seat.getSeatStatus().equals(Status.SELECTED)){
                selectedSeats.add(seat);
            }
        }
        return selectedSeats;
    }

    @Override
    public boolean isShowingSoldOut(Long showingId) {
        return false;
    }

//    @Override
//    public boolean isShowingSoldOut(Long showingId) {
//        List<Seat> listOfSeats = showingRepository.getReferenceById(showingId).getSeats();
//        List<Seat> listOfAvailableSeats = new ArrayList<>();
//        for(Seat seat : listOfSeats){
//            if(seat.getSeatStatus().equals(Status.AVAILABLE)){
//                listOfAvailableSeats.add(seat);
//            }
//        }
//        return listOfAvailableSeats.isEmpty();
//    }

    @Override
    public boolean isShowingCompleted(Long showingId) {
        Showing showing = showingRepository.getReferenceById(showingId);
        if(showing.getShowingDate().equals(LocalDate.now()) || showing.getShowingDate().isAfter(LocalDate.now())){
            if(showing.getShowingTime().isAfter(LocalTime.now())){
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    // CK part
//    @Override
//    public List<String> getAvailableDates(Long movieId) {
//        return showingRepository.findAvailableDatesByMovieId(movieId)
//                .stream()
//                .map(date -> date.format(DateTimeFormatter.ISO_DATE))
//                .collect(Collectors.toList());
//    }

//    @Override
//    public List<TimeSlotDTO> getAvailableTimeSlots(Long movieId, LocalDate date) {
//        return null;
//    }

//    @Override
//    public List<TimeSlotDTO> getAvailableTimeSlots(Long movieId, LocalDate date) {
//        // Get all booked times for this movie and date
//        Set<LocalTime> bookedTimes = showingRepository.findBookedTimesByMovieIdAndDate(movieId, date)
//                .stream()
//                .collect(Collectors.toSet());
//
//        // Convert standard times to DTOs, marking them as available or not
//        return STANDARD_SHOWING_TIMES.stream()
//                .map(time -> TimeSlotDTO.builder()
//                        .time(formatTime(time))
//                        .available(!bookedTimes.contains(time))
//                        .build())
//                .collect(Collectors.toList());
//    }

    @Override
    public Showing addNewShowing(Showing showing) {
        // Validate the showing time is one of our standard times
        if (!STANDARD_SHOWING_TIMES.contains(showing.getShowingTime())) {
            throw new IllegalArgumentException("Invalid showing time");
        }

        // Check if showing already exists
        boolean timeSlotTaken = showingRepository.findBookedTimesByMovieIdAndDate(
                        showing.getMovie().getId(),
                        showing.getShowingDate())
                .contains(showing.getShowingTime());

        if (timeSlotTaken) {
            throw new IllegalStateException("This time slot is already booked");
        }

        // Create a default set of seats based on your theater configuration
        List<Seat> defaultSeats = createDefaultSeats(showing);
        showing.setSeats(defaultSeats);

        // Save the showing
        Showing savedShowing = showingRepository.save(showing);

        // Set the showing reference and save seats
        defaultSeats.forEach(seat -> seat.setShowing(savedShowing));
        seatRepository.saveAll(defaultSeats);

        return savedShowing;
    }

    // Helper method to create default seats
    private List<Seat> createDefaultSeats(Showing showing) {
        List<Seat> seats = new ArrayList<>();
        // Example: Creating seats for rows A-J, seats 1-10
        for (char row = 'A'; row <= 'J'; row++) {
            for (int seatNum = 1; seatNum <= 10; seatNum++) {
                String seatNumber = row + Integer.toString(seatNum); // e.g., A1, A2, ..., J10
                Seat seat = Seat.builder()
                        .seatNumber(seatNumber)
                        .seatStatus(Status.AVAILABLE)
                        .build();
                seats.add(seat);
            }
        }
        return seats;
    }
}

