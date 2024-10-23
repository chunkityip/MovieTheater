package theater.project.MovieTheater.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import theater.project.MovieTheater.DataPersistent.Entity.Seat;
import theater.project.MovieTheater.DataPersistent.Entity.Showing;
import theater.project.MovieTheater.DataPersistent.Repo.ShowingRepository;
import theater.project.MovieTheater.Service.ShowingService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowingServiceImpl implements ShowingService {

    private final ShowingRepository showingRepository;

    @Override
    public Showing getShowingById(Long showingId) {
        return null;
    }

    @Override
    public List<Showing> getAllShowings() {
        return List.of();
    }

    @Override
    public List<Showing> getShowingsByDate(LocalDate date) {
        return List.of();
    }

    @Override
    public List<Showing> getShowingsByDateAndTime(LocalDate date, LocalTime time) {
        return List.of();
    }

    @Override
    public List<Showing> getShowingsByMovieId(Long movieId) {
        return List.of();
    }

    @Override
    public List<Showing> getShowingsByMovieAndDate(Long movieId, LocalDate date) {
        return List.of();
    }

    @Override
    public List<Showing> getShowingsByMovieIdAndTime(Long movieId, LocalTime time) {
        return List.of();
    }

    @Override
    public List<Showing> getShowingsByMovieWithDateAndTime(Long movieId, LocalDate date, LocalTime time) {
        return List.of();
    }

    @Override
    public Showing addNewShowing(Showing showing) {
        return null;
    }

    @Override
    public Showing updateShowing(Long showingId, Showing updatedShowing) {
        return null;
    }

    @Override
    public boolean deleteShowing(Long showingId) {
        return false;
    }

    @Override
    public List<Showing> addMultipleNewShowings(List<Showing> showings) {
        return List.of();
    }

    @Override
    public List<Showing> removeMultipleShowings(List<Showing> showings) {
        return List.of();
    }

    @Override
    public boolean removeAllShowingsByMovieId(Long movieId) {
        return false;
    }

    @Override
    public boolean removeAllShowingsByMovieName(String movieName) {
        return false;
    }

    @Override
    public boolean removeAllShowingsByDate(LocalDate date) {
        return false;
    }

    @Override
    public boolean showingExistsByShowingId(Long showingId) {
        return false;
    }

    @Override
    public boolean showingExistsByMovieId(Long movieId) {
        return false;
    }

    @Override
    public boolean showingExistsByMovieName(Long movieName) {
        return false;
    }

    @Override
    public int getNumOfAvailableSeats(Long showingId) {
        return 0;
    }

    @Override
    public int getNumOfOccupiedSeats(Long showingId) {
        return 0;
    }

    @Override
    public int getNumOfDisabledSeats(Long showingId) {
        return 0;
    }

    @Override
    public List<Seat> getAvailableSeatsForShowing(Long showingId) {
        return List.of();
    }

    @Override
    public List<Seat> getSelectedSeatsForShowing(Long showingId) {
        return List.of();
    }

    @Override
    public List<Seat> getOccupiedSeatsForShowing(Long showingId) {
        return List.of();
    }

    @Override
    public boolean isShowingSoldOut(Long showingId) {
        return false;
    }

    @Override
    public boolean hasShowingCompleted(Long showingId) {
        return false;
    }
}
