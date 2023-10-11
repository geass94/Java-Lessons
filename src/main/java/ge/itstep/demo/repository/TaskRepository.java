package ge.itstep.demo.repository;

import ge.itstep.demo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> getTaskByTaskContainingAndDueDateAfter(String keyword, String date);
}
