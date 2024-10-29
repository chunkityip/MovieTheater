package theater.project.MovieTheater.API.DTO.Concession;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateConcessionRequestDTO {
    private Long id;
    private double price;
}
