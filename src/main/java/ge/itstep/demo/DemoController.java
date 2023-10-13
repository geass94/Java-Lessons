package ge.itstep.demo;

import ge.itstep.demo.dto.TaskDTO;
import ge.itstep.demo.model.Task;
import ge.itstep.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tasks")
public class DemoController {

    @Autowired
    private TaskRepository taskRepository;

    private List<Task> tasks = new ArrayList<>();

    @PostMapping("/")
    public Task create(@RequestBody TaskDTO taskDTO)
    {
//        Task task = new Task(Long.valueOf(taskDTO.id()), taskDTO.task(), taskDTO.note(), taskDTO.dueDate(), taskDTO.completed());
        Task task = this.taskRepository.save(new Task(taskDTO.id(), taskDTO.task(), taskDTO.note(), taskDTO.dueDate(), taskDTO.completed()));
        return task;
    }

    @GetMapping("/")
    public ResponseEntity<List<TaskDTO>> getAll()
    {
        List<Task> tasks = this.taskRepository.findAll();

        return ResponseEntity.of(Optional.of(tasks.stream().map(c -> new TaskDTO(c.getId(), c.getTask(), c.getNote(), c.getDueDate(), c.isCompleted())).collect(Collectors.toList())));

//        return ResponseEntity.of(Optional.of(this.tasks.stream().map(c -> new TaskDTO(c.getId().intValue(), c.getTask(), c.getNote(), c.getDueDate(), c.isCompleted())).collect(Collectors.toList())));
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody TaskDTO dto)
    {
        Task task = taskRepository.getById(Long.valueOf(id));
        task.setTask(dto.task());
        task.setNote(dto.note());
        task.setCompleted(dto.completed());
        task.setDueDate(dto.dueDate());
        taskRepository.save(task);
        return "Updated record at ID: " + id;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id)
    {
        Task task = taskRepository.getById(Long.valueOf(id));
        taskRepository.delete(task);
        return true;
    }


}
