package theater.project.MovieTheater.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import theater.project.MovieTheater.API.DTO.User.CreateAdminRequestDTO;
import theater.project.MovieTheater.API.DTO.User.LoginRequest;
import theater.project.MovieTheater.DataPersistent.Entity.User;
import theater.project.MovieTheater.DataPersistent.Repo.UserRepository;
import theater.project.MovieTheater.Exception.UserNotFoundException;
import theater.project.MovieTheater.Service.UserService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private User user;

    @Override
    public CreateAdminRequestDTO registerUser(UserDto registrationRequest) {
        Optional<User> request = userRepository.findById(userRepository.getUserById(userRepository.getUserId()));

        CreateAdminRequestDTO reponse = userRepository.save(user);

        User user = User.builder()
                .name(registrationRequest.getName())
                //.email(registrationRequest.getEmail()) // Optional
                .build();

        User saveUser = userRepo.save(user);

        UserDto userDto = entityDtoMapper.mapUserToDtoBasic(saveUser);

        return Response.builder()
                .status(200)
                .message("User successfully added")
                .build();

    }

    @Override
    public User loginUser(LoginRequest loginRequest) {
        User user = userRepository.getUserByName(loginRequest.getUserName())
                .orElseThrow(() -> new UserNotFoundException("User not found"));



    }
}
