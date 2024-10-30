package theater.project.MovieTheater.Service.Impl;

import org.springframework.data.jpa.repository.JpaRepository;
import theater.project.MovieTheater.API.DTO.Payment.CardRequestDTO;
import theater.project.MovieTheater.DataPersistent.Entity.Payment;
import theater.project.MovieTheater.Service.CartService;

public class CartServiceImpl implements CartService {
    @Override
    public Payment processCardDetails(CardRequestDTO cardRequestDTO) {
        return null;
    }
}
