package ge.itstep.demo;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ge.itstep.demo.dto.StudentDTO;
import ge.itstep.demo.services.StudentService;
import jakarta.annotation.PostConstruct;

@Component
public class StudentsSeeder {
    @Autowired
    private StudentService service;

    @PostConstruct
    public void seed()
    {
        Random random = new Random();
        for (int i = 0; i < 9; i++) {
            this.service.addStudent(new StudentDTO(null, "Student " + i, random.nextInt(10) + 1));
        }
    }
}
