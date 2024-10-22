package theater.project.MovieTheater.API.DTO.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAdminRequestDTO {
    private Long id; // This will be populated after the user is saved
    private String name;
}

