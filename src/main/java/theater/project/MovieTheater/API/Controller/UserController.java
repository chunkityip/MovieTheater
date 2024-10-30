package theater.project.MovieTheater.API.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import theater.project.MovieTheater.API.DTO.User.CreateAdminRequestDTO;
import theater.project.MovieTheater.API.DTO.User.LoginRequest;
import theater.project.MovieTheater.API.DTO.User.UserProfileDTO;
import theater.project.MovieTheater.DataPersistent.Entity.User;
import theater.project.MovieTheater.DataPersistent.Repo.UserRepository;
import theater.project.MovieTheater.Service.Impl.UserServiceImpl;
import theater.project.MovieTheater.Service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;
    private final UserRepository repo;

    @PostMapping("/register")
    public ResponseEntity<CreateAdminRequestDTO> registerUser(@RequestBody CreateAdminRequestDTO requestDTO) {
        CreateAdminRequestDTO registeredUser = userService.registerUser(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    }

    @PostMapping("/login") // Change to POST
    public ResponseEntity<User> loginUser(@RequestBody LoginRequest loginRequest) {
        User loggedInUser = userService.loginUser(loginRequest);
        return ResponseEntity.ok(loggedInUser);
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<UserProfileDTO> getUserProfile(@PathVariable Long id) {
        UserProfileDTO userProfile = userService.getUserProfile(id);
        return ResponseEntity.ok(userProfile);
    }


//    @GetMapping("/profile/{adminId}") // Or any other suitable endpoint
//    public ResponseEntity<UserProfileDTO> getAdminProfile(@PathVariable Long id) {
//        UserProfileDTO adminProfile = userService.getAdminProfile(id);
//        return ResponseEntity.ok(adminProfile);
//    }


}