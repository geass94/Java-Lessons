package ge.itstep.demo;

import ge.itstep.demo.dto.TaskDTO;
import ge.itstep.demo.model.Task;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		Task task = new Task(1, "This is task", "This is note", "2023-10-12", false);
		TaskDTO dto = new TaskDTO(123, "This record task", "This is record note", "2023-10-12", true);

	}

}
