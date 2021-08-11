package com.example.lib.service;

import com.example.lib.repository.BookRepository;
import com.example.lib.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BookService implements IBookService {
    private BookRepository bookRepository;
    private StudentRepository studentRepository;

    @Autowired
    public BookService(BookRepository bookRepository, StudentRepository studentRepository) {
        this.bookRepository = bookRepository;
        this.studentRepository = studentRepository;
    }
}