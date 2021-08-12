package com.example.lib.controller;

import com.example.lib.model.Student;
import com.example.lib.service.StudentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
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


    @DeleteMapping("/deleteStudent/{id}")
    public Student deleteStudentById(@PathVariable long id) {
        return _studentService.deleteStudentById(id);
    }

    @PostMapping("/addStudent")
    public Student createStudent(@RequestBody Student student) {
        return _studentService.createStudent(student);
    }
}