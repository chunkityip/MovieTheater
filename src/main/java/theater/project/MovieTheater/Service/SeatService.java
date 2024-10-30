package theater.project.MovieTheater.Service;

import org.springframework.stereotype.Service;
import theater.project.MovieTheater.DataPersistent.Entity.Seat;
import theater.project.MovieTheater.DataPersistent.Enum.Status;

import java.util.List;

@Service
public interface SeatService {

    Seat getSeatBySeatId(Long seatId);
    Seat getSeatBySeatNumber(String seatNumber);


//    ***** BELOW METHODS ARE AVAILABLE ON SHOWING SERVICE *****
//    List<Seat> getSeatsByShowingId(Long showingId);
//    List<Seat> getAvailableSeatsByShowingId(Long showingId);
//    List<Seat> getOccupiedSeatsByShowingId(Long showingId);
//    List<Seat> getDisabledSeatsByShowingId(Long showingId);

    Status getSeatStatusBySeatId(Long seatId);
    boolean isAvailable(Long seatId);
    boolean isOccupied(Long seatId);
    boolean isSelected(Long seatId);
    boolean isDisabled(Long seatId);


    void occupySeat(Long seatId);
    void selectSeat(Long seatId);
    void unselectSeat(Long seatId);
    void disableSeat(Long seatId);

    List<String> occupySeatsInBulkBySeatIds(List<Long> seatIds);
    List<String> selectSeatsInBulkBySeatIds(List<Long> seatIds);
    List<String> unselectSeatsInBulkBySeatIds(List<Long> seatIds);
    List<String> disableSeatsInBulkBySeatIds(List<Long> seatIds);



//    since you can only select an available seat, that means unselecting the seat will make it available back again.
}

