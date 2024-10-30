package theater.project.MovieTheater.API.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import theater.project.MovieTheater.API.DTO.Movie.CreateMovieRequestDTO;
import theater.project.MovieTheater.API.DTO.Movie.ShowMovieResponseDTO;
import theater.project.MovieTheater.API.DTO.Ticket.GeneratedTicketDTO;
import theater.project.MovieTheater.Exception.MovieNotFoundException;
import theater.project.MovieTheater.Exception.TicketNotFoundException;
import theater.project.MovieTheater.Service.MovieService;
import theater.project.MovieTheater.Service.SeatService;
import theater.project.MovieTheater.Service.TicketService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class TicketController {
    private final TicketService ticketService;
    private final MovieService movieService;
    private final SeatService seatService;

    @GetMapping
    public List<GeneratedTicketDTO> getAllTickets() {
        return ticketService.getAllTickets();
    }

//    @PostMapping("/generate")
//    public ResponseEntity<GeneratedTicketDTO> generateTicket(
//            @RequestParam("movieTitle") String movieTitle,
//            @RequestParam("showDate") LocalDate showDate,
//            @RequestParam("showTime") LocalTime showTime,
//            @RequestParam("seatNumber") String seatNumber)
//            throws MovieNotFoundException {
//
//        GeneratedTicketDTO generatedTicket = ticketService.generateTicket(
//                movieService.getMovieByTitle(movieTitle),
//                showDate, showTime, 25.00,
//                seatService.getSeatBySeatNumber(seatNumber));
//        return ResponseEntity.status(HttpStatus.CREATED).body(generatedTicket);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneratedTicketDTO> getTicketById(@PathVariable Long id) {
        try {
            GeneratedTicketDTO ticket = ticketService.getTicketByTicketId(id);
            return ResponseEntity.ok(ticket);
        } catch (TicketNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
