package theater.project.MovieTheater.DTO.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import theater.project.MovieTheater.Enum.UserRole;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerRequestDTO {
    private String name;
    private UserRole userRole = UserRole.CUSTOMER;
}
