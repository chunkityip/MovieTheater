package theater.project.MovieTheater.API.DTO.Movie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowMovieResponseDTO {
    private long id;
    private String title;
    private String description;
    private String coverImageBase64; // Changed from byte[] to String
}

