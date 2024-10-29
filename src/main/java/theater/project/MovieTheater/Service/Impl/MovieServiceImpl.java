package theater.project.MovieTheater.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import theater.project.MovieTheater.API.DTO.Movie.CreateMovieRequestDTO;
import theater.project.MovieTheater.API.DTO.Movie.ShowMovieResponseDTO;
import theater.project.MovieTheater.DataPersistent.Entity.Movie;
import theater.project.MovieTheater.DataPersistent.Repo.MovieRepository;
import theater.project.MovieTheater.Exception.MovieNotFoundException;
import theater.project.MovieTheater.Service.MovieService;

import java.util.List;

//import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.title;


@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;

    // movie by id to connect the date
    @Override
    public Movie getMovieById(long id) throws MovieNotFoundException {
        return movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException("Movie not found"));

        // under this convert the above movie entity into a showmovieresponseDTO
        // before that research how to store image in postgres if having difficulty then take cover image off entity and dont store
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public ShowMovieResponseDTO getMovieById(Long id) {
        return null;
    }

    @Override
    public ShowMovieResponseDTO getMovieByTitle(String title) {
        return null;
    }

    @Override
    public String deleteMovie(String title) {
//        Movie movie = movieRepository.findByTitle(title)
//                .OrElseThrow(() -)
        return null;
    }

    @Override
    public CreateMovieRequestDTO createMovie(CreateMovieRequestDTO createMovieRequestDTO) {
        // create movie entity from DTO
//        title, description, and image , multiple images?
//        save movie entity

//        if (movieRepository.existsById(createMovieRequestDTO.getId())) {
//            throw new IllegalArgumentException("Id already in use");
//        }
//        convert entity to DTO . Movie repo

        Movie newMovie = Movie.builder()
                .title(createMovieRequestDTO.getTitle())
                .description(createMovieRequestDTO.getDescription())
                .coverImage(createMovieRequestDTO.getCoverImage())
                .build();

        Movie savedMovie = movieRepository.save(newMovie);

        return CreateMovieRequestDTO.builder()
                .id(savedMovie.getId())
                .title(savedMovie.getTitle())
                .description(savedMovie.getDescription())
                .coverImage(savedMovie.getCoverImage())
                .build();

//    maybe update movie?


//    crud,create movie, update movie (make changes),  get movie, delete movie,
//   function in interface and override
//get all movies, controller, DTO
// /movie, create
//@autowired, inject repo, SQL query
//     get
//    post, update, delete


    }
}