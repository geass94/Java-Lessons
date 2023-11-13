package ge.itstep.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ge.itstep.demo.dto.StudentDTO;
import ge.itstep.demo.models.Student;
import ge.itstep.demo.services.StudentService;
import ge.itstep.demo.services.TeamService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;
    @Autowired
    private TeamService teamService;
    
    @PostMapping("")
    public ResponseEntity<Student> create(@RequestBody @Valid StudentDTO dto)
    {
        return ResponseEntity.ok(this.service.addStudent(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody StudentDTO dto) {
        return ResponseEntity.ok(this.service.updateStudent(id, dto));
    }

    @GetMapping("")
    public ResponseEntity<List<Student>> getAll()
    {
        return ResponseEntity.ok(this.service.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.findOne(id));
    }


    @GetMapping("/teams")
    public ResponseEntity<List> getTeams()
    {
        return ResponseEntity.ok(teamService.createTeams());
    }
 
}
