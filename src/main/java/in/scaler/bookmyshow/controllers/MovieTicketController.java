package in.scaler.bookmyshow.controllers;

import in.scaler.bookmyshow.models.*;
import in.scaler.bookmyshow.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieTicketController {

    @Autowired
    private MovieService movieService;

//    @Autowired
//    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movieList = movieService.getAllMovies();
        return ResponseEntity.ok(movieList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @GetMapping("/shows/{movieId}")
    public ResponseEntity<List<Show>> getShowsByMovie(@PathVariable Long movieId) {
        return ResponseEntity.ok(movieService.getShowsByMovie(movieId));
    }

//    @PostMapping("/users/register")
//    public ResponseEntity<User> registerUser(@RequestBody User user) {
//        return ResponseEntity.ok(userService.registerUser(user));
//    }
//
//
//    @GetMapping("/users/{userId}")
//    public ResponseEntity<User> getUser(@PathVariable Long userId) {
//        return ResponseEntity.ok(userService.getUserById(userId));
//    }


}
