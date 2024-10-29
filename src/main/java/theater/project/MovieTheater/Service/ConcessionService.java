package theater.project.MovieTheater.Service;

import org.springframework.stereotype.Service;
import theater.project.MovieTheater.API.DTO.Concession.CreateConcessionRequestDTO;
import theater.project.MovieTheater.API.DTO.Concession.UpdateConcessionRequestDTO;
import theater.project.MovieTheater.DataPersistent.Entity.Concession;

import java.util.List;

@Service
public interface ConcessionService {
    Concession addConcession(CreateConcessionRequestDTO concession);
//    Concession updateConcession(UpdateConcessionRequestDTO concession);
//    void deleteConcession(Long concession);
    List<Concession> getAllConcessions();    //Different size of the same concession "Large, small popcorn"
    List<Concession> getConcessionsByName(String name);
}
