package ge.itstep.demo.Repository;

import ge.itstep.demo.Models.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRep extends JpaRepository<Students,Long> {

}
