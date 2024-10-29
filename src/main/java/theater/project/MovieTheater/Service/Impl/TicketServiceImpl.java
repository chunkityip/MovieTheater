package theater.project.MovieTheater.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import theater.project.MovieTheater.API.DTO.Ticket.GeneratedTicketDTO;
import theater.project.MovieTheater.DataPersistent.Entity.Movie;
import theater.project.MovieTheater.DataPersistent.Entity.Seat;
import theater.project.MovieTheater.DataPersistent.Entity.Ticket;
import theater.project.MovieTheater.DataPersistent.Repo.TicketRepository;
import theater.project.MovieTheater.Exception.TicketNotFoundException;
import theater.project.MovieTheater.Service.TicketService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
//    private final SeatRepository seatRepository;
//    private final MovieRepository movieRepository;

    @Override
    public GeneratedTicketDTO generateTicket(Movie movie, LocalDate date, LocalTime time, double price, Seat seat) {
        Ticket ticketToSave = Ticket.builder()
                                .movie(movie)
                                .date(date)
                                .time(time)
                                .price(price)
                                .seat(seat)
                                .build();
        Ticket savedTicket = ticketRepository.save(ticketToSave);
        return GeneratedTicketDTO.builder()
                .movieTitle(savedTicket.getMovie().getTitle())
                .showDate(savedTicket.getDate())
                .showTime(savedTicket.getTime())
                .seatNumber(savedTicket.getSeat().getSeatNumber())
                .build();
    }

    @Override
    public GeneratedTicketDTO getTicketByTicketId(Long ticketId) {
        Ticket ticket = ticketRepository.getReferenceById(ticketId);
        return GeneratedTicketDTO.builder()
                .movieTitle(ticket.getMovie().getTitle())
                .showDate(ticket.getDate())
                .showTime(ticket.getTime())
                .seatNumber(ticket.getSeat().getSeatNumber())
                .build();
    }

    @Override
    public GeneratedTicketDTO getTicketBySeatWithDateAndTime(Seat seat, LocalDate date, LocalTime time) {
        Ticket targetTicket = null;
        List<Ticket> ticketsBySeat = ticketRepository.getTicketsBySeat(seat);
        for (Ticket ticket : ticketsBySeat){
            if (ticket.getDate().isEqual(date) && ticket.getTime().equals(time)){
                targetTicket = ticket;
                break;
            } else throw new TicketNotFoundException("Ticket Not Found.");
        }
        return GeneratedTicketDTO.builder()
                .movieTitle(targetTicket.getMovie().getTitle())
                .showDate(targetTicket.getDate())
                .showTime(targetTicket.getTime())
                .seatNumber(targetTicket.getSeat().getSeatNumber())
                .build();
    }

    @Override
    public List<GeneratedTicketDTO> getAllTickets() {
        List<GeneratedTicketDTO> listOfTicketDTOs = new ArrayList<>();
        List<Ticket> listOfTickets = ticketRepository.findAll();
        for(Ticket ticket : listOfTickets){
            GeneratedTicketDTO ticketDTO = GeneratedTicketDTO.builder()
                    .movieTitle(ticket.getMovie().getTitle())
                    .showDate(ticket.getDate())
                    .showTime(ticket.getTime())
                    .seatNumber(ticket.getSeat().getSeatNumber())
                    .build();
            listOfTicketDTOs.add(ticketDTO);
        }
        return listOfTicketDTOs;
    }

    @Override
    public List<Ticket> getAllTicketsByMovie(Movie movie) {
        return ticketRepository.getTicketsByMovie(movie);
    }

    @Override
    public List<Ticket> getAllTicketsByDate(LocalDate date) {
        return ticketRepository.getTicketsByDate(date);
    }

    @Override
    public List<Ticket> getAllTicketsByTime(LocalTime time) {
        return ticketRepository.getTicketsByTime(time);
    }

    @Override
    public double getRevenueByMovieId(Long movieId) {
        double ticketPrice = 25.00;
        return ticketRepository.getCountOfTicketsByMovieId(movieId)*ticketPrice;
    }




}
