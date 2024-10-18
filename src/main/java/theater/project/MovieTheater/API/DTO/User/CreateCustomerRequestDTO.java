package theater.project.MovieTheater.API.DTO.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import theater.project.MovieTheater.DataPersistent.Enum.UserRole;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerRequestDTO {
    private String name;
    private UserRole userRole = UserRole.CUSTOMER;
}
