package theater.project.MovieTheater.API.DTO.Payment;

import lombok.Data;

@Data
public class CardRequestDTO {
    private String name;
    private String cardNumber;
    private String expiry;
    private String cvv;
    private String amount;
}
