package ge.itstep.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ge.itstep.demo.dto.StudentDTO;
import ge.itstep.demo.exceptions.NotFoundException;
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

    public Student updateStudent(Long id, StudentDTO dto) {
        Optional<Student> student = this.studentRepository.findById(id);
        if (!student.isPresent()) throw new NotFoundException("Student by ID: " + id + " was not found!");

        student.ifPresent(s -> {
            s.setFullName(dto.fullName());
            s.setPower(dto.power());
            this.studentRepository.save(s);
        });

        return student.get();
    }

    public List<Student> getAllStudents()
    {
        return this.studentRepository.findAll();
    }

    public Student findOne(Long id) {
        Optional<Student> student = this.studentRepository.findById(id);

        if (!student.isPresent()) throw new NotFoundException("Student by ID: " + id + " was not found!");

        return student.get();
    }
}
