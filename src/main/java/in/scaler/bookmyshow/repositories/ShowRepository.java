package in.scaler.bookmyshow.repositories;

import in.scaler.bookmyshow.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
//    @Override
//    Optional<Show> findById(Long aLong);
}