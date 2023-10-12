package ge.itstep.demo.repository;
import ge.itstep.demo.model.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipRepository extends JpaRepository<Ship,Long> {
}