package ge.itstep.demo;

import ge.itstep.demo.dto.TaskDTO;
import ge.itstep.demo.model.Task;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/*
	* 	რეგისტრაცია
	* 		იუზერის შემოტანა
	* 	დალოგინება
	* 		როლების სისტემის შემოტანა
	* 	პროფილის ნახვა
	* 	თამაშის შექმნა
	* 	ლიდერბორდის ნახვა
	*
	* */

}
