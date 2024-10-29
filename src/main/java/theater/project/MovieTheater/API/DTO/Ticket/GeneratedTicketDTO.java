package theater.project.MovieTheater.API.DTO.Ticket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeneratedTicketDTO {
    private String movieTitle;
    private LocalDate showDate;
    private LocalTime showTime;
    private String seatNumber;
}

