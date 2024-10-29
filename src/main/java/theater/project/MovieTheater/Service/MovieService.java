package theater.project.MovieTheater.Service;

import org.springframework.stereotype.Service;
import theater.project.MovieTheater.API.DTO.Movie.CreateMovieRequestDTO;
import theater.project.MovieTheater.API.DTO.Movie.ShowMovieResponseDTO;
import theater.project.MovieTheater.DataPersistent.Entity.Movie;
import theater.project.MovieTheater.Exception.MovieNotFoundException;

@Service
public interface MovieService {
    // movie by id to connect the date
    Movie getMovieById(long id) throws MovieNotFoundException;

    //   id is connecting data to movie, seat,payment.
    ShowMovieResponseDTO getMovieById(Long id);
    ShowMovieResponseDTO getMovieByTitle(String title);
    CreateMovieRequestDTO createMovie(CreateMovieRequestDTO requestDTO);
    String deleteMovie(String title);
}
