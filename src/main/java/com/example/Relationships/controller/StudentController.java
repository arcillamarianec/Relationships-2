package com.example.Relationships.controller;

import com.example.Relationships.model.Student;
import com.example.Relationships.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping()
    List<Student> getStudents(){
        return studentRepository.findAll();
    }

    @PostMapping
    Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

}
