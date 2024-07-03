package jo.za.repositories;

import jo.za.entities.Return;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ReturnRepository extends JpaRepository <Return, Long> {

}
