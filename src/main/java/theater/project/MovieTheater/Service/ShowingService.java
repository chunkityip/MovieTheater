package theater.project.MovieTheater.Service;

import org.springframework.stereotype.Service;
import theater.project.MovieTheater.API.DTO.Showing.AllSeatStatusResponseDTO;
import theater.project.MovieTheater.API.DTO.Showing.ShowingSelectionResponseDTO;
import theater.project.MovieTheater.API.DTO.Showing.TimeSlotDTO;
import theater.project.MovieTheater.DataPersistent.Entity.Seat;
import theater.project.MovieTheater.DataPersistent.Entity.Showing;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public interface ShowingService {
    Showing getShowingById(Long showingId);
    List<Showing> getAllShowings();

    List<Showing> getShowingsByDate(LocalDate date);
    List<Showing> getShowingsByDateAndTime(LocalDate date, LocalTime time);
    List<Showing> getShowingsByMovieId(Long movieId);
    List<Showing> getShowingsByMovieAndDate(Long movieId, LocalDate date);
    List<Showing> getShowingsByMovieIdAndTime(Long movieId, LocalTime time);
    ShowingSelectionResponseDTO getShowingByMovieWithDateAndTime(Long movieId, LocalDate date, LocalTime time);


    // ADMIN
//    Showing addNewShowing(Showing showing);
    void deleteShowing(Long showingId);

    List<Showing> addMultipleNewShowings(List<Showing> showings);
    void removeMultipleShowings(List<Showing> showings);

    void removeAllShowingsByMovieId(Long movieId);
    void removeAllShowingsByMovieName(String movieName);
    void removeAllShowingsByDate(LocalDate date);

    boolean showingExistsByShowingId(Long showingId);
    boolean showingExistsByMovieId(Long movieId);
    boolean showingExistsByMovieName(String movieName);

    int getNumOfAvailableSeats(Long showingId);
    int getNumOfOccupiedSeats(Long showingId);
    int getNumOfDisabledSeats(Long showingId);

    AllSeatStatusResponseDTO getAllSeatsForShowing(Long showingId);
    List<Seat> getAvailableSeatsForShowing(Long showingId);
    List<Seat> getDisabledSeatsForShowing(Long showingId);
    List<Seat> getOccupiedSeatsForShowing(Long showingId);
    List<Seat> getSelectedSeatsForShowing(Long showingId);

    boolean isShowingSoldOut(Long showingId);
    boolean isShowingCompleted(Long showingId);

    Showing addNewShowing(Showing showing);


    // CK part
//    List<String> getAvailableDates(Long movieId);
//    List<TimeSlotDTO> getAvailableTimeSlots(Long movieId, LocalDate date);
//    Showing addNewShowing(Showing showing);
}
