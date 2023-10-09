package ge.itstep.demo;

import ge.itstep.demo.dto.TaskDTO;
import ge.itstep.demo.model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/tasks")
public class DemoController {

    @GetMapping("/")
    public String index()
    {
        return "this is working";
    }

    @PostMapping("/")
    public Task create(@RequestBody TaskDTO taskDTO)
    {
        Task task = new Task(taskDTO.id(), taskDTO.task(), taskDTO.note(), taskDTO.dueDate(), taskDTO.completed());
        return task;
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id)
    {
        return "Updated record at ID: " + id;
    }


}
