package ge.itstep.demo.Service;

import ge.itstep.demo.Dto.StudentDto;
import ge.itstep.demo.Models.Students;
import ge.itstep.demo.Repository.StudentRep;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRep studentRep;
    public StudentService(StudentRep studentRep) {
        this.studentRep = studentRep;
    }
    public Students CreateStudent(StudentDto dto){
        Students students = new Students();
        students.setFullName(dto.getFullName());
        students.setPower(dto.getPower());
       return this.studentRep.save(students);
    }
}
