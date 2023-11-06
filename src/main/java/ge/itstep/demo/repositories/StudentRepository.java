package ge.itstep.demo.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import ge.itstep.demo.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
