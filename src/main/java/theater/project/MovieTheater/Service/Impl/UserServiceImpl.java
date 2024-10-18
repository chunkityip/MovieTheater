package theater.project.MovieTheater.Service.Impl;

import org.springframework.stereotype.Service;
import theater.project.MovieTheater.API.DTO.User.CreateAdminRequestDTO;
import theater.project.MovieTheater.DataPersistent.Entity.User;
import theater.project.MovieTheater.DataPersistent.Repo.UserRepository;
import theater.project.MovieTheater.Service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public UserRepository registerUser(CreateAdminRequestDTO requestDTO) {
        requestDTO.setName(requestDTO.getName());
        //requestDTO.setUserRole(userRole.Admin);
        userRepository.save(requestDTO);

        return userRepository;

    }

    @Override
    public User loginUser(AmdinReponse) {
        /**
        if User getName is null
        isElseThrow(() -> UserNotFoundException("User not found");
         */



    }
}
