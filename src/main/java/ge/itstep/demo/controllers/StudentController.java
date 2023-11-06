package ge.itstep.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ge.itstep.demo.dto.StudentDTO;
import ge.itstep.demo.models.Student;
import ge.itstep.demo.services.StudentService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;
    
    @PostMapping("")
    public ResponseEntity<Student> create(@RequestBody @Valid StudentDTO dto)
    {

        return ResponseEntity.ok(this.service.addStudent(dto));
    }

}
