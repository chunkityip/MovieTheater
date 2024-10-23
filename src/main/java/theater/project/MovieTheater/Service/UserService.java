package theater.project.MovieTheater.Service;

import org.springframework.stereotype.Service;
import theater.project.MovieTheater.API.DTO.User.AdminProfileDTO;
import theater.project.MovieTheater.API.DTO.User.CreateAdminRequestDTO;
import theater.project.MovieTheater.API.DTO.User.LoginRequest;
import theater.project.MovieTheater.API.DTO.User.UserProfileDTO;
import theater.project.MovieTheater.DataPersistent.Entity.User;
import theater.project.MovieTheater.DataPersistent.Repo.UserRepository;


public interface UserService {

    CreateAdminRequestDTO registerUser(CreateAdminRequestDTO requestDTO);
    User loginUser(LoginRequest loginRequest);
    UserProfileDTO getUserProfile(Long id);
//    AdminProfileDTO getAdminProfile(Long id); // For final Data Analyze

}
