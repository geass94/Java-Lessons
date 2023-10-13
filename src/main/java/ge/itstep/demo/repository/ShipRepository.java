package ge.itstep.demo.repository;

import ge.itstep.demo.model.Ship;
import ge.itstep.demo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShipRepository extends JpaRepository<Ship, Long> {
    Ship getByCordsXAndCordsY(Integer x, Integer y);
}
