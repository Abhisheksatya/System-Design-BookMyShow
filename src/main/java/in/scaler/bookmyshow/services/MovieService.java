package in.scaler.bookmyshow.services;

import in.scaler.bookmyshow.models.Movie;
import in.scaler.bookmyshow.models.Show;
import in.scaler.bookmyshow.repositories.MovieRepository;
import in.scaler.bookmyshow.repositories.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private MovieRepository movieRepository;
    private ShowRepository showRepository;
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        return movie.orElseGet(Movie::new);
    }

    public List<Show> getShowsByMovie(Long movieId) {
        Movie movie = getMovieById(movieId);
        return showRepository.findByMovie(movie);
    }
}
