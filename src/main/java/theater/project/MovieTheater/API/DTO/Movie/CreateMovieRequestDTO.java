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
    private String title;
    private String description;
    @Lob
    private byte[] coverImage;
}
