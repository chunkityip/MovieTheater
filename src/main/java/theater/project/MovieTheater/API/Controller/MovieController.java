package theater.project.MovieTheater.API.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import theater.project.MovieTheater.API.DTO.Movie.CreateMovieRequestDTO;
import theater.project.MovieTheater.API.DTO.Movie.ShowMovieResponseDTO;
import theater.project.MovieTheater.API.DTO.User.CreateAdminRequestDTO;
import theater.project.MovieTheater.DataPersistent.Entity.Movie;
import theater.project.MovieTheater.DataPersistent.Repo.MovieRepository;
import theater.project.MovieTheater.Service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class MovieController {

    private final MovieService movieService;
    private final MovieRepository repo;

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(long id) {
        Movie movie = movieService.getMovieById(id);
        //CreateMovieRequestDTO getMovieById = movieService.getMovieById(ShowMovieResponseDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(movie);
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return repo.findAll();
    }

    //    create move, test on swagger
    @PostMapping("/create")
    public ResponseEntity<CreateMovieRequestDTO> createMovie(@RequestBody CreateMovieRequestDTO createMovieRequestDTO) {
        CreateMovieRequestDTO createdMovie = movieService.createMovie(createMovieRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMovie);
    }

// delete movie
//    @DeleteMapping("/title/{title}")
//    public ResponseEntity<String> deleteMovieByTitle(@)

}