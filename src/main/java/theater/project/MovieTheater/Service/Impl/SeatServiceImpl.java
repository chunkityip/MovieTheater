package theater.project.MovieTheater.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import theater.project.MovieTheater.DataPersistent.Entity.Seat;
import theater.project.MovieTheater.DataPersistent.Enum.Status;
import theater.project.MovieTheater.DataPersistent.Repo.SeatRepository;
import theater.project.MovieTheater.Exception.SeatNotFoundException;
import theater.project.MovieTheater.Exception.TicketNotFoundException;
import theater.project.MovieTheater.Service.SeatService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;


    @Override
    public Seat getSeatBySeatId(Long seatId) {
        Seat seat = seatRepository.getSeatById(seatId);
        if (seat == null){
            throw new SeatNotFoundException("Seat Not Found by Seat Id: " + seatId);
        } else return seat;
    }

    @Override
    public Seat getSeatBySeatNumber(String seatNumber) {
        Seat seat = seatRepository.getSeatBySeatNumber(seatNumber);
        if (seat == null){
            throw new SeatNotFoundException("Seat Not Found by Seat Number: " + seatNumber);
        } else return seat;
    }

    @Override
    public Status getSeatStatusBySeatId(Long seatId) {
        return seatRepository.getSeatById(seatId).getSeatStatus();
    }

    @Override
    public boolean isAvailable(Long seatId) {
        return seatRepository.getSeatById(seatId).getSeatStatus()==Status.AVAILABLE;
    }

    @Override
    public boolean isOccupied(Long seatId) {
        return seatRepository.getSeatById(seatId).getSeatStatus()==Status.OCCUPIED;
    }

    @Override
    public boolean isSelected(Long seatId) {
        return seatRepository.getSeatById(seatId).getSeatStatus()==Status.SELECTED;
    }

    @Override
    public boolean isDisabled(Long seatId) {
        return seatRepository.getSeatById(seatId).getSeatStatus()==Status.DISABLED;
    }

    @Override
    public void occupySeat(Long seatId) {
        seatRepository.getSeatById(seatId).setSeatStatus(Status.OCCUPIED);
    }

    @Override
    public void selectSeat(Long seatId) {
        seatRepository.getSeatById(seatId).setSeatStatus(Status.SELECTED);
    }

    @Override
    public void unselectSeat(Long seatId) {
        seatRepository.getSeatById(seatId).setSeatStatus(Status.AVAILABLE);
    }

    @Override
    public void disableSeat(Long seatId) {
        seatRepository.getSeatById(seatId).setSeatStatus(Status.DISABLED);
    }

    @Override
    public List<String> occupySeatsInBulkBySeatIds(List<Long> seatIds) {
        List<String> occupiedSeatNumbers = new ArrayList<>();
        for (Long seatId : seatIds){
            Seat seat = seatRepository.getSeatById(seatId);
            if(seat.getSeatStatus().equals(Status.SELECTED)) {
                seat.setSeatStatus(Status.OCCUPIED);
                occupiedSeatNumbers.add(seat.getSeatNumber());
            }
        }
        return occupiedSeatNumbers;
    }

    @Override
    public List<String> selectSeatsInBulkBySeatIds(List<Long> seatIds) {
        List<String> selectedSeatNumbers = new ArrayList<>();
        for (Long seatId : seatIds){
            Seat seat = seatRepository.getSeatById(seatId);
            if(seat.getSeatStatus().equals(Status.AVAILABLE)) {
                seat.setSeatStatus(Status.SELECTED);
                selectedSeatNumbers.add(seat.getSeatNumber());
            }
        }
        return selectedSeatNumbers;
    }

    @Override
    public List<String> unselectSeatsInBulkBySeatIds(List<Long> seatIds) {
        List<String> unselectedSeatNumbers = new ArrayList<>();
        for (Long seatId : seatIds){
            Seat seat = seatRepository.getSeatById(seatId);
            if(seat.getSeatStatus().equals(Status.SELECTED)) {
                seat.setSeatStatus(Status.AVAILABLE);
                unselectedSeatNumbers.add(seat.getSeatNumber());
            }
        }
        return unselectedSeatNumbers;
    }

    @Override
    public List<String> disableSeatsInBulkBySeatIds(List<Long> seatIds) {
        List<String> disabledSeatNumbers = new ArrayList<>();
        for (Long seatId : seatIds){
            Seat seat = seatRepository.getSeatById(seatId);
            if(seat.getSeatStatus().equals(Status.AVAILABLE)) {
                seat.setSeatStatus(Status.DISABLED);
                disabledSeatNumbers.add(seat.getSeatNumber());
            }
        }
        return disabledSeatNumbers;
    }
}