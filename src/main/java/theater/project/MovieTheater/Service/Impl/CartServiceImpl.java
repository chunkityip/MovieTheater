package theater.project.MovieTheater.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import theater.project.MovieTheater.API.DTO.Payment.CardRequestDTO;
import theater.project.MovieTheater.API.DTO.Ticket.TicketInfoDTO;
import theater.project.MovieTheater.DataPersistent.Entity.Movie;
import theater.project.MovieTheater.DataPersistent.Entity.Payment;
import theater.project.MovieTheater.DataPersistent.Entity.Showing;
import theater.project.MovieTheater.Service.CartService;
import theater.project.MovieTheater.Service.TicketService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final TicketService ticketService;

    @Override
    public Payment processCardDetails(CardRequestDTO cardRequestDTO) {
        return null;
    }

    @Override
    public List<TicketInfoDTO> getInfoForUnsavedTickets(Showing showing) {
        return ticketService.getUnsavedTicketInfo(showing);
    }
}
