package theater.project.MovieTheater.Service.Impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import theater.project.MovieTheater.DataPersistent.Entity.Seat;
import theater.project.MovieTheater.DataPersistent.Entity.Showing;
import theater.project.MovieTheater.DataPersistent.Enum.Status;
import theater.project.MovieTheater.DataPersistent.Repo.SeatRepository;
import theater.project.MovieTheater.Service.SeatService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SeatServiceImplTest {

    @MockBean
    private SeatRepository seatRepository;
    @Autowired
    private SeatService seatService;
    Seat seat0, seat1, seat2, seat3, seat4, seat5, seat6, seat7, seat8, seat9;

    @BeforeEach
    void setUp() {
        seat0 = new Seat();
        seat1 = new Seat();
        seat2 = new Seat();
        seat3 = new Seat();
        seat4 = new Seat();
        seat5 = new Seat();
        seat6 = new Seat();
        seat7 = new Seat();
        seat8 = new Seat();
        seat9 = new Seat();

        Mockito.when(seatRepository.getSeatById(0L)).thenReturn(seat0);
        Mockito.when(seatRepository.getSeatById(1L)).thenReturn(seat1);
        Mockito.when(seatRepository.getSeatById(2L)).thenReturn(seat2);
        Mockito.when(seatRepository.getSeatById(3L)).thenReturn(seat3);
        Mockito.when(seatRepository.getSeatById(4L)).thenReturn(seat4);
        Mockito.when(seatRepository.getSeatById(5L)).thenReturn(seat5);
        Mockito.when(seatRepository.getSeatById(6L)).thenReturn(seat6);
        Mockito.when(seatRepository.getSeatById(7L)).thenReturn(seat7);
        Mockito.when(seatRepository.getSeatById(8L)).thenReturn(seat8);
        Mockito.when(seatRepository.getSeatById(9L)).thenReturn(seat9);
        Mockito.when(seatRepository.getSeatBySeatNumber("A1")).thenReturn(seat5);
        Mockito.when(seatRepository.getSeatBySeatNumber("B2")).thenReturn(seat6);
        Mockito.when(seatRepository.getSeatBySeatNumber("C3")).thenReturn(seat7);
        Mockito.when(seatRepository.getSeatBySeatNumber("D4")).thenReturn(seat8);
        Mockito.when(seatRepository.getSeatBySeatNumber("E5")).thenReturn(seat9);



    }

    @Test
    void getSeatBySeatId() {
        assertEquals(seat0, seatService.getSeatBySeatId(0L));
        assertEquals(seat1, seatService.getSeatBySeatId(1L));
        assertEquals(seat2, seatService.getSeatBySeatId(2L));
        assertEquals(seat3, seatService.getSeatBySeatId(3L));
        assertEquals(seat4, seatService.getSeatBySeatId(4L));
    }

    @Test
    void getSeatBySeatNumber() {
        assertEquals(seat5, seatService.getSeatBySeatNumber("A1"));
        assertEquals(seat6, seatService.getSeatBySeatNumber("B2"));
        assertEquals(seat7, seatService.getSeatBySeatNumber("C3"));
        assertEquals(seat8, seatService.getSeatBySeatNumber("D4"));
        assertEquals(seat9, seatService.getSeatBySeatNumber("E5"));
    }

    @Test
    void getSeatStatusBySeatId() {
        seat0.setSeatStatus(Status.AVAILABLE);
        seat1.setSeatStatus(Status.SELECTED);
        seat2.setSeatStatus(Status.OCCUPIED);
        seat3.setSeatStatus(Status.DISABLED);
        seat4.setSeatStatus(Status.AVAILABLE);
        assertEquals(Status.AVAILABLE, seatService.getSeatStatusBySeatId(0L));
        assertEquals(Status.SELECTED, seatService.getSeatStatusBySeatId(1L));
        assertEquals(Status.OCCUPIED, seatService.getSeatStatusBySeatId(2L));
        assertEquals(Status.DISABLED, seatService.getSeatStatusBySeatId(3L));
        assertEquals(Status.AVAILABLE, seatService.getSeatStatusBySeatId(4L));
    }

    @Test
    void isAvailable() {
        seat0.setSeatStatus(Status.AVAILABLE);
        seat1.setSeatStatus(Status.AVAILABLE);
        seat2.setSeatStatus(Status.AVAILABLE);
        seat3.setSeatStatus(Status.AVAILABLE);
        seat4.setSeatStatus(Status.AVAILABLE);
        assertTrue(seatService.isAvailable(0L));
        assertTrue(seatService.isAvailable(1L));
        assertTrue(seatService.isAvailable(2L));
        assertTrue(seatService.isAvailable(3L));
        assertTrue(seatService.isAvailable(4L));
    }

    @Test
    void isOccupied() {
        seat0.setSeatStatus(Status.OCCUPIED);
        seat1.setSeatStatus(Status.OCCUPIED);
        seat2.setSeatStatus(Status.OCCUPIED);
        seat3.setSeatStatus(Status.OCCUPIED);
        seat4.setSeatStatus(Status.OCCUPIED);
        assertTrue(seatService.isOccupied(0L));
        assertTrue(seatService.isOccupied(1L));
        assertTrue(seatService.isOccupied(2L));
        assertTrue(seatService.isOccupied(3L));
        assertTrue(seatService.isOccupied(4L));
    }

    @Test
    void isSelected() {
        seat0.setSeatStatus(Status.SELECTED);
        seat1.setSeatStatus(Status.SELECTED);
        seat2.setSeatStatus(Status.SELECTED);
        seat3.setSeatStatus(Status.SELECTED);
        seat4.setSeatStatus(Status.SELECTED);
        assertTrue(seatService.isSelected(0L));
        assertTrue(seatService.isSelected(1L));
        assertTrue(seatService.isSelected(2L));
        assertTrue(seatService.isSelected(3L));
        assertTrue(seatService.isSelected(4L));
    }

    @Test
    void isDisabled() {
        seat0.setSeatStatus(Status.DISABLED);
        seat1.setSeatStatus(Status.DISABLED);
        seat2.setSeatStatus(Status.DISABLED);
        seat3.setSeatStatus(Status.DISABLED);
        seat4.setSeatStatus(Status.DISABLED);
        assertTrue(seatService.isDisabled(0L));
        assertTrue(seatService.isDisabled(1L));
        assertTrue(seatService.isDisabled(2L));
        assertTrue(seatService.isDisabled(3L));
        assertTrue(seatService.isDisabled(4L));
    }

    @Test
    void occupySeat() {
        seat5.setSeatStatus(Status.AVAILABLE);
        seat6.setSeatStatus(Status.SELECTED);
        seat7.setSeatStatus(Status.SELECTED);
        seat8.setSeatStatus(Status.DISABLED);
        seat9.setSeatStatus(Status.AVAILABLE);
        seatService.occupySeat(5L);
        seatService.occupySeat(6L);
        seatService.occupySeat(7L);
        seatService.occupySeat(8L);
        seatService.occupySeat(9L);
        assertEquals(Status.OCCUPIED, seatService.getSeatStatusBySeatId(5L));
        assertEquals(Status.OCCUPIED, seatService.getSeatStatusBySeatId(6L));
        assertEquals(Status.OCCUPIED, seatService.getSeatStatusBySeatId(7L));
        assertEquals(Status.OCCUPIED, seatService.getSeatStatusBySeatId(8L));
        assertEquals(Status.OCCUPIED, seatService.getSeatStatusBySeatId(9L));
    }

    @Test
    void selectSeat() {
        seat5.setSeatStatus(Status.AVAILABLE);
        seat6.setSeatStatus(Status.OCCUPIED);
        seat7.setSeatStatus(Status.OCCUPIED);
        seat8.setSeatStatus(Status.DISABLED);
        seat9.setSeatStatus(Status.AVAILABLE);
        seatService.selectSeat(5L);
        seatService.selectSeat(6L);
        seatService.selectSeat(7L);
        seatService.selectSeat(8L);
        seatService.selectSeat(9L);
        assertEquals(Status.SELECTED, seatService.getSeatStatusBySeatId(5L));
        assertEquals(Status.SELECTED, seatService.getSeatStatusBySeatId(6L));
        assertEquals(Status.SELECTED, seatService.getSeatStatusBySeatId(7L));
        assertEquals(Status.SELECTED, seatService.getSeatStatusBySeatId(8L));
        assertEquals(Status.SELECTED, seatService.getSeatStatusBySeatId(9L));
    }

    @Test
    void unselectSeat() {
        seat5.setSeatStatus(Status.AVAILABLE);
        seat6.setSeatStatus(Status.SELECTED);
        seat7.setSeatStatus(Status.SELECTED);
        seat8.setSeatStatus(Status.DISABLED);
        seat9.setSeatStatus(Status.SELECTED);
        seatService.unselectSeat(5L);
        seatService.unselectSeat(6L);
        seatService.unselectSeat(7L);
        seatService.unselectSeat(8L);
        seatService.unselectSeat(9L);
        assertEquals(Status.AVAILABLE, seatService.getSeatStatusBySeatId(5L));
        assertEquals(Status.AVAILABLE, seatService.getSeatStatusBySeatId(6L));
        assertEquals(Status.AVAILABLE, seatService.getSeatStatusBySeatId(7L));
        assertEquals(Status.AVAILABLE, seatService.getSeatStatusBySeatId(8L));
        assertEquals(Status.AVAILABLE, seatService.getSeatStatusBySeatId(9L));
    }

    @Test
    void disableSeat() {
        seat5.setSeatStatus(Status.AVAILABLE);
        seat6.setSeatStatus(Status.SELECTED);
        seat7.setSeatStatus(Status.OCCUPIED);
        seat8.setSeatStatus(Status.DISABLED);
        seat9.setSeatStatus(Status.SELECTED);
        seatService.disableSeat(5L);
        seatService.disableSeat(6L);
        seatService.disableSeat(7L);
        seatService.disableSeat(8L);
        seatService.disableSeat(9L);
        assertEquals(Status.DISABLED, seatService.getSeatStatusBySeatId(5L));
        assertEquals(Status.DISABLED, seatService.getSeatStatusBySeatId(6L));
        assertEquals(Status.DISABLED, seatService.getSeatStatusBySeatId(7L));
        assertEquals(Status.DISABLED, seatService.getSeatStatusBySeatId(8L));
        assertEquals(Status.DISABLED, seatService.getSeatStatusBySeatId(9L));
    }

    @Test
    void occupySeatsInBulkBySeatIds() {
        seat5.setSeatStatus(Status.AVAILABLE);
        seat6.setSeatStatus(Status.SELECTED);
        seat7.setSeatStatus(Status.SELECTED);
        seat8.setSeatStatus(Status.DISABLED);
        seat9.setSeatStatus(Status.AVAILABLE);

        List<Long> listOfSeatIdsToOccupy = List.of(5L, 6L, 7L, 8L, 9L);
        seatService.occupySeatsInBulkBySeatIds(listOfSeatIdsToOccupy);

//        seatService.occupySeatsInBulkBySeatIds() only occupies seats that are selected or already occupied.
//        result should be seat6 and seat7 only.

        assertNotEquals(Status.OCCUPIED, seat5.getSeatStatus());
        assertEquals(Status.OCCUPIED, seat6.getSeatStatus());
        assertEquals(Status.OCCUPIED, seat7.getSeatStatus());
        assertNotEquals(Status.OCCUPIED, seat8.getSeatStatus());
        assertNotEquals(Status.OCCUPIED, seat9.getSeatStatus());
    }

    @Test
    void selectSeatsInBulkBySeatIds() {
        seat5.setSeatStatus(Status.AVAILABLE);
        seat6.setSeatStatus(Status.SELECTED);
        seat7.setSeatStatus(Status.OCCUPIED);
        seat8.setSeatStatus(Status.DISABLED);
        seat9.setSeatStatus(Status.AVAILABLE);

        List<Long> listOfSeatIdsToOccupy = List.of(5L, 6L, 7L, 8L, 9L);
        seatService.selectSeatsInBulkBySeatIds(listOfSeatIdsToOccupy);

//        seatService.selectSeatsInBulkBySeatIds() only can select seats that are available or already selected.
//        result should be seat5, seat6 and seat9 only.

        assertEquals(Status.SELECTED, seat5.getSeatStatus());
        assertEquals(Status.SELECTED, seat6.getSeatStatus());
        assertNotEquals(Status.SELECTED, seat7.getSeatStatus());
        assertNotEquals(Status.SELECTED, seat8.getSeatStatus());
        assertEquals(Status.SELECTED, seat9.getSeatStatus());
    }

    @Test
    void unselectSeatsInBulkBySeatIds() {
        seat5.setSeatStatus(Status.AVAILABLE);
        seat6.setSeatStatus(Status.SELECTED);
        seat7.setSeatStatus(Status.SELECTED);
        seat8.setSeatStatus(Status.DISABLED);
        seat9.setSeatStatus(Status.OCCUPIED);

        List<Long> listOfSeatIdsToOccupy = List.of(5L, 6L, 7L, 8L, 9L);
        seatService.unselectSeatsInBulkBySeatIds(listOfSeatIdsToOccupy);

//        seatService.unselectSeatsInBulkBySeatIds() only can unselect seats that are selected or already available.
//        result should be seat5, seat6 and seat7 only.

        assertEquals(Status.AVAILABLE, seat5.getSeatStatus());
        assertEquals(Status.AVAILABLE, seat6.getSeatStatus());
        assertEquals(Status.AVAILABLE, seat7.getSeatStatus());
        assertNotEquals(Status.AVAILABLE, seat8.getSeatStatus());
        assertNotEquals(Status.AVAILABLE, seat9.getSeatStatus());
    }

    @Test
    void disableSeatsInBulkBySeatIds() {
        seat5.setSeatStatus(Status.AVAILABLE);
        seat6.setSeatStatus(Status.SELECTED);
        seat7.setSeatStatus(Status.AVAILABLE);
        seat8.setSeatStatus(Status.DISABLED);
        seat9.setSeatStatus(Status.OCCUPIED);

        List<Long> listOfSeatIdsToOccupy = List.of(5L, 6L, 7L, 8L, 9L);
        seatService.disableSeatsInBulkBySeatIds(listOfSeatIdsToOccupy);

//        seatService.disableSeatsInBulkBySeatIds() only can disabled seats that are available or already disabled.
//        result should be seat5, seat7 and seat8 only.

        assertEquals(Status.DISABLED, seat5.getSeatStatus());
        assertNotEquals(Status.DISABLED, seat6.getSeatStatus());
        assertEquals(Status.DISABLED, seat7.getSeatStatus());
        assertEquals(Status.DISABLED, seat8.getSeatStatus());
        assertNotEquals(Status.DISABLED, seat9.getSeatStatus());
    }
}