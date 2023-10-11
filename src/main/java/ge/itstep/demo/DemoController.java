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
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tasks")
public class DemoController {
    private List<Task> tasks = new ArrayList<>();

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/")
    public ResponseEntity<List<TaskDTO>> index()
    {
        List<Task> tasks = taskRepository.findAll();
        return ResponseEntity.of(Optional.of(tasks.stream().map(c -> new TaskDTO(c.getId(), c.getTask(), c.getNote(), c.getDueDate(), c.isCompleted())).collect(Collectors.toList())));
    }

    @PostMapping("/")
    public Task create(@RequestBody TaskDTO taskDTO)
    {
        Random rand = new Random();
        Task task = new Task(taskDTO.task(), taskDTO.note(), taskDTO.dueDate(), taskDTO.completed());
        taskRepository.save(task);
        return task;
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody TaskDTO updatedTask)
    {
        Task task = queryTaskById(id,this.tasks);

        task.setTask(updatedTask.task());
        task.setNote(updatedTask.note());
        task.setCompleted(updatedTask.completed());
        task.setDueDate(updatedTask.dueDate());
        this.tasks.set(getTaskPosition(id,this.tasks),task);

        return "Updated record at ID: " + id;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id){
        int index = getTaskPosition(id, this.tasks);
        if(index > -1){
            this.tasks.remove(index);
            return true;
        }
        return false;
    }
    static Task queryTaskById(int id, List<Task> tasks){
        for (Task task: tasks) {
            if (task.getId() == id){
                return task;
            }
        }
        return null;
    }
    static int getTaskPosition(int id, List<Task> tasks){
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }

}
