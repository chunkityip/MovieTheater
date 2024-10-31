package theater.project.MovieTheater.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import theater.project.MovieTheater.API.DTO.User.AdminProfileDTO;
import theater.project.MovieTheater.API.DTO.User.CreateAdminRequestDTO;
import theater.project.MovieTheater.API.DTO.User.LoginRequest;
import theater.project.MovieTheater.API.DTO.User.UserProfileDTO;
import theater.project.MovieTheater.DataPersistent.Entity.*;
import theater.project.MovieTheater.DataPersistent.Repo.*;
import theater.project.MovieTheater.Exception.UserAlreadyExistsException;
import theater.project.MovieTheater.Exception.UserNotFoundException;
import theater.project.MovieTheater.Service.UserService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ConcessionRepository concessionRepository; // Make sure to create this repository
    private final MovieRepository movieRepository; // Make sure to create this repository
    private final PaymentRepository paymentRepository; // Make sure to create this repository
    private final SeatRepository seatRepository; // Make sure to create this repository
    private final TicketRepository ticketRepository; // Make sure to create this repository

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

    //Testing

    @Override
    public UserProfileDTO getUserProfile(Long userId) {
        User user = userRepository.getUserById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        return UserProfileDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    // For final Data Analyze
//    @Override
//    public AdminProfileDTO getAdminProfile(Long id) {
//        // Fetch the admin profile if needed
//        User adminUser = userRepository.getUserById(id)
//                .orElseThrow(() -> new UserNotFoundException("Admin not found"));
//
//        // Fetch all the necessary data
//        List<Concession> concessions = concessionRepository.findAll();
//        List<Movie> movies = movieRepository.findAll();
//        List<Payment> payments = paymentRepository.findAll();
//        List<Seat> seats = seatRepository.findAll();
//        List<Ticket> tickets = ticketRepository.findAll();
//
//        // Build and return the AdminProfileDTO
//        return AdminProfileDTO.builder()
//                .userProfile(UserProfileDTO.builder()
//                        .id(adminUser.getId())
//                        .name(adminUser.getName())
//                        .email(adminUser.getEmail())
//                        .build())
//                .concessions(concessions)
//                .movies(movies)
//                .payments(payments)
//                .seats(seats)
//                .tickets(tickets)
//                .build();
//    }
}
