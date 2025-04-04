package in.scaler.bookmyshow.repositories;

import in.scaler.bookmyshow.models.Movie;
import in.scaler.bookmyshow.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    List<Show> findByMovie(Movie movie);

}