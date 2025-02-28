package ups.edu.ec.micromariaDB.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ups.edu.ec.micromariaDB.model.Auto;

public interface AutoRepository extends JpaRepository<Auto, Long> {
}
