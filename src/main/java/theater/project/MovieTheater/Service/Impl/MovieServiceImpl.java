package theater.project.MovieTheater.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import theater.project.MovieTheater.API.DTO.Movie.CreateMovieRequestDTO;
import theater.project.MovieTheater.API.DTO.Movie.ShowMovieResponseDTO;
import theater.project.MovieTheater.DataPersistent.Entity.Movie;
import theater.project.MovieTheater.DataPersistent.Repo.MovieRepository;
import theater.project.MovieTheater.Exception.MovieNotFoundException;
import theater.project.MovieTheater.Service.MovieService;

import java.io.IOException;
import java.util.Base64;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    @Override
    public CreateMovieRequestDTO createMovie(String title, String description, MultipartFile coverImage) throws IOException {
        byte[] imageBytes = null;
        if (coverImage != null && !coverImage.isEmpty()) {
            imageBytes = coverImage.getBytes();
        }

        Movie newMovie = Movie.builder()
                .title(title)
                .description(description)
                .coverImage(imageBytes)
                .build();

        Movie savedMovie = movieRepository.save(newMovie);

        return CreateMovieRequestDTO.builder()
                .id(savedMovie.getId())
                .title(savedMovie.getTitle())
                .description(savedMovie.getDescription())
                .build();
    }

    @Override
    public ShowMovieResponseDTO getMovieById(long id) throws MovieNotFoundException {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found with id: " + id));

        String base64Image = null;
        if (movie.getCoverImage() != null) {
            base64Image = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(movie.getCoverImage());
        }

        return ShowMovieResponseDTO.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .description(movie.getDescription())
                .coverImageBase64(base64Image)
                .build();
    }


    public List<Movie> getAllMovies() {
        return movieRepository.findAll();

    }
}




