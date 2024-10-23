package theater.project.MovieTheater.API.DTO.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import theater.project.MovieTheater.DataPersistent.Entity.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminProfileDTO {
    private UserProfileDTO userProfile; // Optional: Include user profile if needed
    private List<Concession> concessions;
    private List<Movie> movies;
    private List<Payment> payments;
    private List<Seat> seats;
    private List<Ticket> tickets;
    private List<Theater> theaters;
}
