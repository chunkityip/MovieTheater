package theater.project.MovieTheater.API.DTO.Movie;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateMovieRequestDTO {
    private Long id;
    private String title;
    private String description;
    private MultipartFile coverImage; // Changed to MultipartFile
}
