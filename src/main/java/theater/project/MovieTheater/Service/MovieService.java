package theater.project.MovieTheater.Service;

import org.springframework.web.multipart.MultipartFile;
import theater.project.MovieTheater.API.DTO.Movie.CreateMovieRequestDTO;

import java.io.IOException;

public interface MovieService {
    CreateMovieRequestDTO createMovie(String title, String description, MultipartFile coverImage) throws IOException;
}
