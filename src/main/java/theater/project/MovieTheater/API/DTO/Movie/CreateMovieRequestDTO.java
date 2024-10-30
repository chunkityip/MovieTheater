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
<<<<<<< HEAD
    private MultipartFile coverImage; // Changed to MultipartFile
=======

    private String coverImage;
>>>>>>> f7a3f8a1139843218f6926ac4c9298ba12cfb9a0
}
