package com.example.springbootexplored.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Autowired
    private final StudentRepository studentRepository;

    public List<Student> getStudents () {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException(("email is taken"));
        }
        studentRepository.save(student);
        System.out.println(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("student with id " + studentId + "does not exists");
        }
        studentRepository.deleteById(studentId);
    }
}
