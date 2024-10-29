package theater.project.MovieTheater.Service;

import org.springframework.web.multipart.MultipartFile;
import theater.project.MovieTheater.API.DTO.Movie.CreateMovieRequestDTO;
import theater.project.MovieTheater.API.DTO.Movie.ShowMovieResponseDTO;
import theater.project.MovieTheater.DataPersistent.Entity.Movie;
import theater.project.MovieTheater.Exception.MovieNotFoundException;

import java.io.IOException;

public interface MovieService {
    CreateMovieRequestDTO createMovie(String title, String description, MultipartFile coverImage) throws IOException;
    ShowMovieResponseDTO getMovieById(long id) throws MovieNotFoundException;
    ShowMovieResponseDTO getMovieDTOByTitle(String title) throws MovieNotFoundException;
    Movie getMovieByTitle(String title) throws MovieNotFoundException;
}
