package com.example.springbootexplored.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    CommandLineRunner commandLineRunner(
            StudentRepository repository) {
        return args -> {
            Student steve = new Student (
                    "Steve",
                    "steve9@gmail.com",
                    LocalDate.of(2022, Month.DECEMBER, 2),
                    26
            );
            Student dave = new Student (
                    "Dave",
                    "dave9@gmail.com",
                    LocalDate.of(2012, Month.APRIL, 5),
                    27
            );
            repository.saveAll(
                    List.of(steve, dave)
            );
        };
    }
}
