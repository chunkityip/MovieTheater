package theater.project.MovieTheater.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import theater.project.MovieTheater.DataPersistent.Entity.Seat;
import theater.project.MovieTheater.DataPersistent.Enum.Status;
import theater.project.MovieTheater.DataPersistent.Repo.SeatRepository;
import theater.project.MovieTheater.Service.SeatService;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    private SeatRepository seatRepository;


    @Override
    public Seat getSeatBySeatId(Long seatId) {
        return seatRepository.getSeatById(seatId);
    }

    @Override
    public Seat getSeatBySeatNumber(String seatNumber) {
        return seatRepository.getSeatBySeatNumber(seatNumber);
    }

    @Override
    public List<Seat> getAllSeatsByMovieId(Long movieId) {
        return List.of();
    }

    @Override
    public List<Seat> getAvailableSeatsByMovieId(Long movieId) {
        return List.of();
    }

    @Override
    public List<Seat> getOccupiedSeatsByMovieId(Long movieId) {
        return List.of();
    }

    @Override
    public List<Seat> getDisabledSeatsByMovieId(Long movieId) {
        return List.of();
    }

    @Override
    public Status getSeatStatus(Long seatId) {
        return null;
    }

    @Override
    public boolean isAvailable(Long seatId) {
        return false;
    }

    @Override
    public boolean isOccupied(Long seatId) {
        return false;
    }

    @Override
    public boolean isSelected(Long seatId) {
        return false;
    }

    @Override
    public void occupySeat(Long seatId) {

    }

    @Override
    public void selectSeat(Long seatId) {

    }

    @Override
    public void unselectSeat(Long seatId) {

    }

    @Override
    public void disableSeat(Long seatId) {

    }

    @Override
    public void occupySeatsInBulk(List<Long> seatIds) {

    }

    @Override
    public void selectSeatsInBulk(List<Long> seatIds) {

    }

    @Override
    public void unselectSeatsInBulk(List<Long> seatIds) {

    }

    @Override
    public void disableSeatsInBulk(List<Long> seatIds) {

    }
}
