package com.example.lib.service;

import com.example.lib.libMapper.dtos.StudentSlimDto;
import com.example.lib.libMapper.mappers.LibMapper;
import com.example.lib.model.Book;
import com.example.lib.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private BookRepository _bookRepository;
    @Autowired
    private LibMapper _libMapper;

    public BookService(BookRepository _bookRepository, LibMapper _libMapper) {
        this._bookRepository = _bookRepository;
        this._libMapper = _libMapper;
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
        _bookRepository.save(book);
        return book;
    }

    public Book borrowBook(String title, StudentSlimDto studentSlimDto) {
        Book book = _bookRepository.findByTitle(title);
        if(book != null) {
            List<StudentSlimDto> borrowingHistory = _libMapper.studentToStudentSlimDto(
                    book.getBorrowingHistory()
            );
            borrowingHistory.add(studentSlimDto);
            book.setBorrowingHistory(_libMapper.studentSlimDtoToStudent(
                    borrowingHistory
            ));
        }
        _bookRepository.save(book);
        return book;
    }

}