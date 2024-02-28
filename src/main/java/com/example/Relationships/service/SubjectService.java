package com.example.Relationships.service;
import com.example.Relationships.model.Student;
import com.example.Relationships.model.Subject;
import com.example.Relationships.model.Teacher;
import com.example.Relationships.repository.StudentRepository;
import com.example.Relationships.repository.SubjectRepository;
import com.example.Relationships.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TeacherRepository teacherRepository;
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }
    public Optional<Subject> findByIdSubject(Long id) {
        return subjectRepository.findById(id);
    }
    public Optional<Student> findByIdStudent(Long id) {
        return studentRepository.findById(id);
    }
    public Optional<Teacher> findByIdTeacher(Long id) {
        return teacherRepository.findById(id);
    }

}
