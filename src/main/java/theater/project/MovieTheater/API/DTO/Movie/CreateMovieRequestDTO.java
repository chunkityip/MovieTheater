package theater.project.MovieTheater.API.DTO.Movie;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateMovieRequestDTO {
    private Long id;
    private String title;
    private String description;

    private String coverImage;
}
