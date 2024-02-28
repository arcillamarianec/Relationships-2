package com.example.Relationships.controller;
import com.example.Relationships.model.Student;
import com.example.Relationships.model.Subject;
import com.example.Relationships.model.Teacher;
import com.example.Relationships.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @GetMapping()
    List<Subject> getSubjects(){
        return subjectService.findAll();
    }

    @PostMapping
    Subject createSubject(@RequestBody Subject subject) {
        return subjectService.save(subject);
    }

    @PutMapping("/{subjectId}/students/{studentId}")
    Subject addStudentToSubject(
            @PathVariable Long subjectId,
            @PathVariable Long studentId
    ) {
        Subject subject = subjectService.findByIdSubject(subjectId).get();
        Student student = subjectService.findByIdStudent(studentId).get();
        subject.getEnrolledStudents().add(student);
        return subjectService.save(subject);
    }

    @PutMapping("/{subjectId}/teacher/{teacherId}")
    Subject assignTeacherToSubject(
            @PathVariable Long subjectId,
            @PathVariable Long teacherId
    ) {
        Subject subject = subjectService.findByIdSubject(subjectId).get();
        Teacher teacher = subjectService.findByIdTeacher(teacherId).get();
        subject.setTeacher(teacher);
        return subjectService.save(subject);
    }
}

