package theater.project.MovieTheater.API.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import theater.project.MovieTheater.API.DTO.User.CreateAdminRequestDTO;
import theater.project.MovieTheater.API.DTO.User.LoginRequest;
import theater.project.MovieTheater.DataPersistent.Entity.User;
import theater.project.MovieTheater.Service.Impl.UserServiceImpl;
import theater.project.MovieTheater.Service.UserService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

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


}
