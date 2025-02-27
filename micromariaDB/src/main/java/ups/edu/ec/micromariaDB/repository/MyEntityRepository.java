package ups.edu.ec.micromariaDB.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ups.edu.ec.micromariaDB.model.MyEntity;

public interface MyEntityRepository extends JpaRepository<MyEntity, Long> {
}