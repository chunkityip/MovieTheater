package theater.project.MovieTheater.Service;

import org.springframework.stereotype.Service;
import theater.project.MovieTheater.DataPersistent.Entity.Seat;
import theater.project.MovieTheater.DataPersistent.Enum.Status;

import java.util.List;

@Service
public interface SeatService {

    Seat getSeatBySeatId(Long seatId);
    Seat getSeatBySeatNumber(String seatNumber);

    List<Seat> getAllSeatsByMovieId(Long movieId);
    List<Seat> getAvailableSeatsByMovieId(Long movieId);
    List<Seat> getOccupiedSeatsByMovieId(Long movieId);
    List<Seat> getDisabledSeatsByMovieId(Long movieId);

    Status getSeatStatus(Long seatId);
    boolean isAvailable(Long seatId);
    boolean isOccupied(Long seatId);
    boolean isSelected(Long seatId);

    void occupySeat(Long seatId);
    void selectSeat(Long seatId);
    void unselectSeat(Long seatId);
    void disableSeat(Long seatId);

    void occupySeatsInBulk(List<Long> seatIds);
    void selectSeatsInBulk(List<Long> seatIds);
    void unselectSeatsInBulk(List<Long> seatIds);
    void disableSeatsInBulk(List<Long> seatIds);



//    since you can only select an available seat, that means unselecting the seat will make it available back again.
}

