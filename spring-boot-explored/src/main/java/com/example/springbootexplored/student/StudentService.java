package com.example.springbootexplored.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
