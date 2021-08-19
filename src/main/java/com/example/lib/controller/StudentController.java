package com.example.lib.controller;

import com.example.lib.libMapper.dtos.StudentSlimDto;
import com.example.lib.model.Book;
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
    public String getAllStudentsDetails(Model model, String keyword) {
        model.addAttribute("listStudents", keyword==null ? _studentService.getAllStudents() : _studentService.findStudentByKeyword(keyword));
        model.addAttribute("books", _studentService.getBooks());
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


    @RequestMapping("/deleteStudent/{id}")
    public String deleteStudentById(Model model, @PathVariable long id) {
        _studentService.deleteStudentById(id);
        return "redirect:/students";
    }

    //adding students
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

    @RequestMapping("/editStudent/{id}")
    public String addBookToStudentById(Model model, @PathVariable long id) {
        _studentService.addBookToStudentById(1, id);
        return "redirect:/students";
    }
}