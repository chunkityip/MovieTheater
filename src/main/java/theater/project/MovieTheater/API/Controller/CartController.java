package theater.project.MovieTheater.API.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import theater.project.MovieTheater.API.DTO.Payment.CardRequestDTO;
import theater.project.MovieTheater.DataPersistent.Entity.Payment;
import theater.project.MovieTheater.Service.Impl.CartServiceImpl;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartServiceImpl cartService;

    @PostMapping
    ResponseEntity<Payment> processCardDetails(@RequestBody CardRequestDTO cardRequestDTO){
        Payment payment = null;
        return ResponseEntity.ok(payment);
    }
}
