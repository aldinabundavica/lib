package com.example.lib.service;

import com.example.lib.libMapper.dtos.StudentSlimDto;
import com.example.lib.model.Book;
import com.example.lib.model.Student;
import com.example.lib.model.Writer;

import java.util.List;

public interface IBookService {
    Book createBook(Book book);
    Book getBookById(long id);

    List<Book> getAllBooks();

    Book changeBookStatus(String title, boolean status);

    Book borrowBook(String title, StudentSlimDto studentSlimDto);

    List<Writer> getAllWritersNames();

    List<Book> findBookByKeyword(String keyword);
}
