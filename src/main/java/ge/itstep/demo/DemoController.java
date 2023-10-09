package ge.itstep.demo;

import ge.itstep.demo.dto.TaskDTO;
import ge.itstep.demo.model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tasks")
public class DemoController {

    private List<Task> tasks = new ArrayList<>();

    @GetMapping("/")
    public List<TaskDTO> index()
    {
        return this.tasks.stream().map(c -> new TaskDTO(c.getId(), c.getTask(), c.getNote(), c.getDueDate(), c.isCompleted())).collect(Collectors.toList());
    }

    @PostMapping("/")
    public Task create(@RequestBody TaskDTO taskDTO)
    {
        Task task = new Task(taskDTO.id(), taskDTO.task(), taskDTO.note(), taskDTO.dueDate(), taskDTO.completed());
        this.tasks.add(task);
        return task;
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id)
    {
        return "Updated record at ID: " + id;
    }


}
