package theater.project.MovieTheater.API.DTO.User;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {

    @NotBlank(message = "User name is required")
    private String name;
}
