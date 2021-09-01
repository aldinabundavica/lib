package com.example.lib.controller;

import com.example.lib.model.Student;
import com.example.lib.service.StudentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
public class StudentController {

    private StudentService _studentService;

    public StudentController(StudentService _studentService) {
        this._studentService = _studentService;
    }

    @GetMapping("/allstudents")
    public List<Student> getAllStudents() {
        return _studentService.getAllStudents();
    }

    @GetMapping("student/{id}")
    @ResponseBody
    public Student getStudentById(@PathVariable long id) {
        return _studentService.getStudentById(id);
    }

    @GetMapping("")
    @ResponseBody
    public List<Student> getStudentsByName(@RequestParam(required=true) String name) {
        return _studentService.getStudentsByName(name);
    }


    @DeleteMapping("/delete-student/{id}")
    public Student deleteStudentById(@PathVariable long id) {
        return _studentService.deleteStudentById(id);
    }

    @PostMapping("/create-student")
    public Student createStudent(@RequestBody Student student) {
        return _studentService.createStudent(student);
    }

    @PutMapping("/update-student/{id}")
    public Student updateStudent(@PathVariable long id, @RequestBody Student student) {
        student.setId(id);
        return _studentService.createStudent(student);
    }
}