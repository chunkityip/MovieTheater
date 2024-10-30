package theater.project.MovieTheater.Service.Impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import theater.project.MovieTheater.DataPersistent.Entity.Movie;
import theater.project.MovieTheater.DataPersistent.Entity.Seat;
import theater.project.MovieTheater.DataPersistent.Entity.Showing;
import theater.project.MovieTheater.DataPersistent.Repo.ShowingRepository;
import theater.project.MovieTheater.Service.ShowingService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShowingServiceImplTest {

    @Autowired
    private ShowingService showingService;
    @MockBean
    private ShowingRepository showingRepository;
    @Mock
    private Movie movie;
    @Mock
    private List<Seat> seats;
    Seat seat1, seat2, seat3, seat4, seat5;
    Showing showing1, showing2, showing3, showing4, showing5;

    @BeforeEach
    void setUp() {
        seat1 = new Seat();
        seat2 = new Seat();
        seat3 = new Seat();
        seat4 = new Seat();
        seat5 = new Seat();

        movie = new Movie(0L, "Star Wars", "Action and Adventure", null);
        seats = new ArrayList<>();
        seats.addAll(List.of(new Seat(), new Seat(), new Seat(), new Seat(), new Seat()));

        showing1 = new Showing(1L, movie, LocalDate.of(2024, 10, 28), LocalTime.of(10,0), seats);
        showing2 = new Showing(2L, movie, LocalDate.of(2024, 10, 29), LocalTime.of(10,0), seats);
        showing3 = new Showing(3L, movie, LocalDate.of(2024, 10, 29), LocalTime.of(10,0), seats);
        showing4 = new Showing(4L, movie, LocalDate.of(2024, 10, 30), LocalTime.of(10,0), seats);
        showing5 = new Showing(5L, movie, LocalDate.of(2024, 10, 30), LocalTime.of(10,0), seats);

    }

    @Test
    void getShowingById() {
    }

    @Test
    void getAllShowings() {
    }

    @Test
    void getShowingsByDate() {
    }

    @Test
    void getShowingsByDateAndTime() {
    }

    @Test
    void getShowingsByMovieId() {
    }

    @Test
    void getShowingsByMovieAndDate() {
    }

    @Test
    void getShowingsByMovieIdAndTime() {
    }

    @Test
    void getShowingByMovieWithDateAndTime() {
    }

    @Test
    void addNewShowing() {
    }

    @Test
    void deleteShowing() {
    }

    @Test
    void addMultipleNewShowings() {
    }

    @Test
    void removeMultipleShowings() {
    }

    @Test
    void removeAllShowingsByMovieId() {
    }

    @Test
    void removeAllShowingsByMovieName() {
    }

    @Test
    void removeAllShowingsByDate() {
    }

    @Test
    void showingExistsByShowingId() {
    }

    @Test
    void showingExistsByMovieId() {
    }

    @Test
    void showingExistsByMovieName() {
    }

    @Test
    void getNumOfAvailableSeats() {
    }

    @Test
    void getNumOfOccupiedSeats() {
    }

    @Test
    void getNumOfDisabledSeats() {
    }

    @Test
    void getAllSeatsForShowing() {
    }

    @Test
    void getAvailableSeatsForShowing() {
    }

    @Test
    void getDisabledSeatsForShowing() {
    }

    @Test
    void getOccupiedSeatsForShowing() {
    }

    @Test
    void getSelectedSeatsForShowing() {
    }

    @Test
    void isShowingSoldOut() {
    }

    @Test
    void isShowingCompleted() {
    }
}