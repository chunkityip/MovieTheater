package theater.project.MovieTheater.Service.Impl;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import theater.project.MovieTheater.DataPersistent.Entity.Movie;
import theater.project.MovieTheater.DataPersistent.Repo.MovieRepository;
import theater.project.MovieTheater.Service.MovieService;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;




//, @filterEach

class MovieServiceImplTest {
    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieServiceImpl movieService;

    @Autowired
    Movie movie0, movie1, movie2;

    @BeforeEach
    void setUp() {
        movie0 = new Movie();
        movie1 = new Movie();
        movie2 = new Movie();
    }

//    exception
//    @Test
//    void shouldThrowMovieNotFoundExceptionWhenMovieIsNotFound() {
//        Movie movie = new Movie();
//        movie.setId(1L);
//
//        when(movieRepository.findById(2L).thenThrow(new Movie))
//
//        verify
//
//    }
//    private final MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
//    private final MovieService movieService = new MovieService(movieRepository);
//    @Test
//    void getAllMovies() {
//        List<Movie> expectedMovies = Arrays.asList(new Movie("Barbie"), new Movie("Star Wars"));
//        when(movieRepository.findAll()).thenReturn(expectedMovies);
//
//        List<Movie> actualMovies = movieService.getAllMovies();
//        assertEquals(expectedMovies, actualMovies);
//    }

    @Test
    void getMovieById_ReturnsMovie_WhenMovieExists() {
        Long movieId = 1L;

    }

//    @Test
//    void getMovieByTitle() {
//    }

//    @Test
//    void deleteMovie() {
//    }

    @Test
    void createMovie() {
    }
}