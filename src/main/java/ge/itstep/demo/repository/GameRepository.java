package ge.itstep.demo.repository;

import ge.itstep.demo.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
