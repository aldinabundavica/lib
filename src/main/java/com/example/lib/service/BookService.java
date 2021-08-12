package com.example.lib.service;

import com.example.lib.model.Book;
import com.example.lib.model.Student;
import com.example.lib.model.Writer;
import com.example.lib.repository.BookRepository;
import com.example.lib.repository.StudentRepository;
import com.example.lib.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    private BookRepository _bookRepository;
    private StudentRepository _studentRepository;
    private WriterRepository _writerRepository;

    @Autowired
    public BookService(BookRepository _bookRepository, StudentRepository _studentRepository, WriterRepository _writerRepository) {
        this._bookRepository = _bookRepository;
        this._studentRepository = _studentRepository;
        this._writerRepository = _writerRepository;
    }

    public Book createBook(Book book) {
        return _bookRepository.save(book);
    }

    public Book getBookById(long id) {
        return _bookRepository.findById(id).get();
    }

    public List<Book> getAllBooks() {
        return _bookRepository.findAll();
    }

    public Book changeBookStatus(String title, boolean status) {
        Book book = _bookRepository.findByTitle(title);
        book.setTaken(status);
        return book;
    }

    public Book borrowBook(String title, String studentName, String studentLastname) {
        Book book = _bookRepository.findByTitle(title);
        if(book != null) {
            Student student = _studentRepository.findByNameAndLastname(studentName, studentLastname);
            List<Student> borrowingHistory = book.getBorrowingHistory();
            borrowingHistory.add(student);
            book.setBorrowingHistory(borrowingHistory);
        }
        return book;
    }

}