package theater.project.MovieTheater.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import theater.project.MovieTheater.API.DTO.User.CreateAdminRequestDTO;
import theater.project.MovieTheater.API.DTO.User.LoginRequest;
import theater.project.MovieTheater.DataPersistent.Entity.User;
import theater.project.MovieTheater.DataPersistent.Repo.UserRepository;
import theater.project.MovieTheater.Exception.UserAlreadyExistsException;
import theater.project.MovieTheater.Exception.UserNotFoundException;
import theater.project.MovieTheater.Service.UserService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public CreateAdminRequestDTO registerUser(CreateAdminRequestDTO requestDTO) {
        // Check if the email already exists
        if (userRepository.existsByEmail(requestDTO.getName())) {
            throw new IllegalArgumentException("Name already in use");
        }

        // Create User entity from DTO
        User newUser = User.builder()
                .name(requestDTO.getName())
                .build();

        // Save the user entity
        User savedUser = userRepository.save(newUser);

        // Convert saved entity to DTO to return the response
        return CreateAdminRequestDTO.builder()
                .id(savedUser.getId())
                .name(savedUser.getName())
                .build();
    }

    @Override
    public User loginUser(LoginRequest loginRequest) {
        return userRepository.getUserByName(loginRequest.getName())
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }




}
