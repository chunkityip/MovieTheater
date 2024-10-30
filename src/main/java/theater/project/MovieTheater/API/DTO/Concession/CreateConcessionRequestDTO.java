package theater.project.MovieTheater.API.DTO.Concession;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateConcessionRequestDTO {
    private String itemName;
    private double price;
}
