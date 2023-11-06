package ge.itstep.demo.services;

import org.springframework.stereotype.Service;

import ge.itstep.demo.dto.StudentDTO;
import ge.itstep.demo.models.Student;
import ge.itstep.demo.repositories.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student addStudent(StudentDTO studentDTO)
    {
        Student student = new Student();
        student.setFullName(studentDTO.fullName());
        student.setPower(studentDTO.power());
        return this.studentRepository.save(student);
    }
}
