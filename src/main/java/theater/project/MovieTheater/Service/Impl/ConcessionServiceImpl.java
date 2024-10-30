package theater.project.MovieTheater.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import theater.project.MovieTheater.API.DTO.Concession.CreateConcessionRequestDTO;
import theater.project.MovieTheater.API.DTO.Concession.UpdateConcessionRequestDTO;
import theater.project.MovieTheater.DataPersistent.Entity.Concession;
import theater.project.MovieTheater.DataPersistent.Repo.ConcessionRepository;
import theater.project.MovieTheater.Exception.ConcessionNotFoundException;
import theater.project.MovieTheater.Service.ConcessionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConcessionServiceImpl implements ConcessionService {
    private final ConcessionRepository concessionRepository;

    @Override
    public Concession addConcession(CreateConcessionRequestDTO concession) {
        double newConcessionPrice = concession.getPrice();
        String newConcessionName = concession.getItemName();
        return concessionRepository.save(Concession.builder()
                .itemName(newConcessionName)
                .price(newConcessionPrice)
                .build());
    }

//    @Override
//    public Concession updateConcession(UpdateConcessionRequestDTO requestDTO) {
//        Optional<Concession> existingConcession = concessionRepository.findById(requestDTO.getId());
//        if (existingConcession.isPresent()) {
//            Concession concession = existingConcession.get();
//            concession.setPrice(requestDTO.getPrice());
//            return concessionRepository.save(concession);
//        } else {
//            throw new ConcessionNotFoundException("Concession not found");    }
//    }

    @Override
    public List<Concession> getAllConcessions() {
        return concessionRepository.findAll();
    }

    @Override
    public List<Concession> getConcessionsByName(String name) {
        List<Concession> listOfConcessions = new ArrayList<>();
        for (Concession concession : concessionRepository.findAll()) {
            if (concession.getItemName().equals(name))
                listOfConcessions.add(concession);
        }
        return listOfConcessions;
    }

//    @Override
//    public void deleteConcession(Long concessionId) {
//        Optional<Concession> existingConcession = concessionRepository.findById(concessionId);
//        if (existingConcession.isPresent()) {            // If it exists, delete it
//           concessionRepository.delete(existingConcession.get());
//        } else {            // Throw custom exception if concession is not found
//             throw new ConcessionNotFoundException("Concession with ID " + concessionId + " not found.");
//        }
//    }
}

