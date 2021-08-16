package com.example.lib.controller;

import com.example.lib.libMapper.dtos.StudentSlimDto;
import com.example.lib.model.Student;
import com.example.lib.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class StudentController {

    private StudentService _studentService;

    public StudentController(StudentService _studentService) {
        this._studentService = _studentService;
    }

    @GetMapping("students")
    public String getAllStudents(Model model) {
        List<Student> students = _studentService.getAllStudents();
        model.addAttribute("listStudents", students);
        return "allStudents";
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
    public Student deleteStudentById(long id) {
        return _studentService.deleteStudentById(id);
    }

    @GetMapping("/add")
    public String showCreateStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "addStudent";
    }

    @PostMapping("/addStudent")
    public String createStudent(Student student) {
        Student newStudent = _studentService.createStudent(student);
        if(newStudent != null) {
            return "redirect:/students";
        }
        return "";
    }
}