package com.springboot1.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentServis studentServis;

    @Autowired
    public StudentController(StudentServis studentServis) {
        this.studentServis = studentServis;
    }

    @GetMapping
    public List<Student> hello() {
        return studentServis.getStudent();
    }

    @PostMapping
    public void rigisterNewStudents(@RequestBody Student student) {
        studentServis.addStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id) {
        studentServis.deletestudents(id);
    }
}

