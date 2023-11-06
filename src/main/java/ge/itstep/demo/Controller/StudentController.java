package ge.itstep.demo.Controller;

import ge.itstep.demo.Dto.StudentDto;
import ge.itstep.demo.Models.Students;
import ge.itstep.demo.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/students")
public class StudentController  {

    @Autowired
    private StudentService studentService;
    @PostMapping("")


    public ResponseEntity<Students> AddStudents(@RequestBody @Valid StudentDto studentDto){
    Students st1 = this.studentService.CreateStudent(studentDto);
    return ResponseEntity.ok(st1);
    }
    @GetMapping("/")
    public static void GetStudents(){

    }

}
