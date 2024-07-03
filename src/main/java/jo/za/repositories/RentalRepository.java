package jo.za.repositories;

import jo.za.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RentalRepository extends JpaRepository<Rental, Long> {

}
