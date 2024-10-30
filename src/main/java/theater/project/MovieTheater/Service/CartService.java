package theater.project.MovieTheater.Service;

import org.springframework.stereotype.Service;
import theater.project.MovieTheater.API.DTO.Payment.CardRequestDTO;
import theater.project.MovieTheater.API.DTO.Ticket.TicketInfoDTO;
import theater.project.MovieTheater.DataPersistent.Entity.Movie;
import theater.project.MovieTheater.DataPersistent.Entity.Payment;
import theater.project.MovieTheater.DataPersistent.Entity.Showing;

import java.util.List;

@Service
public interface CartService {
    Payment processCardDetails(CardRequestDTO cardRequestDTO);
    List<TicketInfoDTO> getInfoForUnsavedTickets(Showing showing);
}
