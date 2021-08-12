package com.example.lib.service;

import com.example.lib.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAllStudents();
    Student createStudent(Student student);
    List<Student> getStudentsByName(String name);
    Student getStudentById(long id);
    Student deleteStudentById(long id);
}
