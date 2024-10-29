package theater.project.MovieTheater.API.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import theater.project.MovieTheater.API.DTO.Concession.CreateConcessionRequestDTO;
import theater.project.MovieTheater.DataPersistent.Entity.Concession;
import theater.project.MovieTheater.DataPersistent.Repo.ConcessionRepository;
import theater.project.MovieTheater.Service.ConcessionService;

import java.util.List;

@RestController
@RequestMapping("/concession")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ConcessionController {

    private final ConcessionService concessionService;


    @PostMapping
    public ResponseEntity<Concession> addConcession (@RequestBody CreateConcessionRequestDTO request) {
        Concession concession = concessionService.addConcession(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(concession);
    }

    @GetMapping("/allConcessions")
    public List<Concession> getAllConcessions(){
        return concessionService.getAllConcessions();
    }

    @GetMapping("/{itemName}")
    public List<Concession> getConcessionByName(@PathVariable("itemName") String itemName){
        return concessionService.getConcessionsByName(itemName);
    }
}
