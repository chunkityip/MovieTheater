package theater.project.MovieTheater.API.DTO.Showing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowingAvailabilityResponseDTO {
    private Long movieId;
    private List<String> availableDates;
    private List<TimeSlotDTO> availableTimeSlots;
}
