package theater.project.MovieTheater.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import theater.project.MovieTheater.API.DTO.Movie.CreateMovieRequestDTO;
import theater.project.MovieTheater.DataPersistent.Entity.Movie;
import theater.project.MovieTheater.DataPersistent.Repo.MovieRepository;
import theater.project.MovieTheater.Service.MovieService;

import java.io.IOException;
import java.util.Base64;

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

            // Convert byte array back to Base64 string for response
            String coverImageBase64 = null;
            if (savedMovie.getCoverImage() != null) {
                coverImageBase64 = Base64.getEncoder().encodeToString(savedMovie.getCoverImage());
            }

            return CreateMovieRequestDTO.builder()
                    .id(savedMovie.getId())
                    .title(savedMovie.getTitle())
                    .description(savedMovie.getDescription())
                    .build();
        }
    }
