package in.scaler.bookmyshow.controllers;

import in.scaler.bookmyshow.models.*;
import in.scaler.bookmyshow.services.BookingService;
import in.scaler.bookmyshow.services.MovieService;
import in.scaler.bookmyshow.services.PaymentService;
import in.scaler.bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieTicketController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserService userService;

    @Autowired
    private PaymentService paymentService;

    // --------------------- MOVIE CONTROLLER ---------------------

    // Get all movies
    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movieList = movieService.getAllMovies();
        return ResponseEntity.ok(movieList);
    }

    // Get movie by ID
    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    // --------------------- SHOW CONTROLLER ---------------------

    // Get all shows for a movie
    @GetMapping("/shows/{movieId}")
    public ResponseEntity<List<Show>> getShowsByMovie(@PathVariable Long movieId) {
        return ResponseEntity.ok(movieService.getShowsByMovie(movieId));
    }

    // --------------------- USER CONTROLLER ---------------------

    // Register new user
    @PostMapping("/users/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    // Get user details
    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    // --------------------- BOOKING CONTROLLER ---------------------

    // Book a ticket



    // Get user bookings
    @GetMapping("/bookings/user/{userId}")
    public ResponseEntity<List<Booking>> getUserBookings(@PathVariable Long userId) {
        return ResponseEntity.ok(bookingService.getBookingsByUser(userId));
    }

    // Cancel a booking
    @DeleteMapping("/bookings/{bookingId}")
    public ResponseEntity<String> cancelBooking(@PathVariable Long bookingId) {
        bookingService.cancelBooking(bookingId);
        return ResponseEntity.ok("Booking Cancelled Successfully!");
    }

    // --------------------- PAYMENT CONTROLLER ---------------------

    // Make a payment
    @PostMapping("/payments")
    public ResponseEntity<Payment> makePayment(@RequestBody Payment paymentRequest) {
        return ResponseEntity.ok(paymentService.processPayment(paymentRequest));
    }

    // Get payment details
    @GetMapping("/payments/{paymentId}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long paymentId) {
        return ResponseEntity.ok(paymentService.getPaymentById(paymentId));
    }
}
