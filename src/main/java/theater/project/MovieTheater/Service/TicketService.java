package theater.project.MovieTheater.Service;

import org.springframework.stereotype.Service;
import theater.project.MovieTheater.API.DTO.Ticket.GeneratedTicketDTO;
import theater.project.MovieTheater.API.DTO.Ticket.TicketInfoDTO;
import theater.project.MovieTheater.API.DTO.User.CreateAdminRequestDTO;
import theater.project.MovieTheater.API.DTO.User.LoginRequest;
import theater.project.MovieTheater.API.DTO.User.UserProfileDTO;
import theater.project.MovieTheater.DataPersistent.Entity.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public interface TicketService {

    GeneratedTicketDTO generateTicket(Movie movie, LocalDate date, LocalTime time, double price, Seat seat);
    GeneratedTicketDTO getTicketByTicketId(Long id);
    GeneratedTicketDTO getTicketBySeatWithDateAndTime(Seat seat, LocalDate date, LocalTime time);
    List<GeneratedTicketDTO> getAllTickets();
    List<Ticket> getAllTicketsByMovie(Movie movie);
    List<Ticket> getAllTicketsByDate(LocalDate date);
    List<Ticket> getAllTicketsByTime(LocalTime time);
    List<TicketInfoDTO>  getUnsavedTicketInfo(Showing showing);
    double getRevenueByMovieId(Long movieId);

}
