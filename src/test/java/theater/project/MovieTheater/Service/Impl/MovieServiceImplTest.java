package theater.project.MovieTheater.Service.Impl;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import theater.project.MovieTheater.DataPersistent.Repo.MovieRepository;
import theater.project.MovieTheater.Service.MovieService;

import static org.junit.jupiter.api.Assertions.*;




//@BeforeEach, @filterEach

class MovieServiceImplTest {
    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieServiceImpl movieService;

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

    @Test
    void getAllMovies() {
    }

    @Test
    void testGetMovieById() {
    }

    @Test
    void getMovieByTitle() {
    }

    @Test
    void deleteMovie() {
    }

    @Test
    void createMovie() {
    }
}