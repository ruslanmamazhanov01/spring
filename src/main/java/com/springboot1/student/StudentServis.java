package com.springboot1.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServis {

    private final StudentRepository repository;

    @Autowired
    public StudentServis(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getStudent() {
        return repository.findAll();
    }

    public void addStudent(Student student) {
        Optional<Student> student1 = repository.findStudentByEmail(student.getEmail());
        if (student1.isPresent())
            throw new IllegalStateException("taken email");
        repository.save(student);
    }

    public void deletestudents(Long studentId) {
        boolean ex = repository.existsById(studentId);
        if (!ex) {
            throw new IllegalStateException("student with id " + studentId + " does not exist");
        }
        repository.deleteById(studentId);
    }

}