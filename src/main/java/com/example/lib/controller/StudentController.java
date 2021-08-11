package com.example.lib.controller;

import com.example.lib.exception.ResourceNotFoundException;
import com.example.lib.model.Student;
import com.example.lib.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/library/")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("students")
    public List<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }

    @GetMapping("student/{id}")
    @ResponseBody
    public ResponseEntity<Student> getStudentById(@PathVariable long id)
        throws ResourceNotFoundException {
            Student student = studentRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("No student with id ::" + id));

            return ResponseEntity.ok().body(student);
        }

/*
    @DeleteMapping("/deletebyid/{id}")
    public Student deleteStudentById(@PathVariable long id) {
        Student student = studentRepository.findById(id);

        this.studentRepository.delete(student);
        return student;
    }
*/
    @PostMapping("")
    public Student createStudent(@RequestBody Student student) {
        return this.studentRepository.save(student);
    }
}