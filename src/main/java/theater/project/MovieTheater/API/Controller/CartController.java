package theater.project.MovieTheater.API.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import theater.project.MovieTheater.API.DTO.Payment.CardRequestDTO;
import theater.project.MovieTheater.API.DTO.Ticket.TicketInfoDTO;
import theater.project.MovieTheater.DataPersistent.Entity.Payment;
import theater.project.MovieTheater.DataPersistent.Entity.Showing;
import theater.project.MovieTheater.Service.CartService;
import theater.project.MovieTheater.Service.ShowingService;
import theater.project.MovieTheater.Service.TicketService;

import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final TicketService ticketService;

    @GetMapping
    public List<TicketInfoDTO> getInfoOfUnsavedTickets(@Param("showing") Showing showing){
        return ticketService.getUnsavedTicketInfo(showing);
    }

    @PostMapping
    ResponseEntity<Payment> processCardDetails(@RequestBody CardRequestDTO cardRequestDTO){
        Payment payment = null;
        return ResponseEntity.ok(payment);
    }
}
