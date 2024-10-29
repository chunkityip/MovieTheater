package theater.project.MovieTheater.API.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import theater.project.MovieTheater.DataPersistent.Entity.Movie;
import theater.project.MovieTheater.Service.Impl.HomeService;

import java.util.List;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class HomeController {

    private final HomeService service;

    @GetMapping
    public List<Movie> getAllMovies(){
        return service.getAllMovies();
    }
}
