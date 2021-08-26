package com.example.lib.service;

import com.example.lib.libMapper.dtos.BookSlimDto;
import com.example.lib.libMapper.dtos.StudentSlimDto;
import com.example.lib.libMapper.mappers.LibMapper;
import com.example.lib.model.Book;
import com.example.lib.model.Student;
import com.example.lib.repository.BookRepository;
import com.example.lib.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements IStudentService{

    private final StudentRepository _studentRepository;
    private final BookRepository _bookRepository;
    private final LibMapper _libMapper;

    @Autowired
    public StudentService(StudentRepository _studentRepository, BookRepository _bookRepository, LibMapper _libMapper) {
        this._studentRepository = _studentRepository;
        this._bookRepository = _bookRepository;
        this._libMapper = _libMapper;
    }

    public List<Student> getAllStudents() {
        return _studentRepository.findAll();
    }

    public List<Book> getBooks() { return _bookRepository.findAll(); }

    public Student createStudent(Student student) {
        return _studentRepository.save(student);
    }

    public List<Student> getStudentsByName(String name) {
        return _studentRepository.findByName(name);
    }

    public Student getStudentById(long id) {
        return _studentRepository.findById(id).get();
    }

    public Student deleteStudentById(long id) {
        Student student = _studentRepository.findById(id).get();
        _studentRepository.delete(student);
        return student;
    }


    public List<Student> findStudentByKeyword(String keyword) {
        return _studentRepository.findByKeyword(keyword);
    }

}
