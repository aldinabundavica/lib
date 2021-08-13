package com.example.lib.service;

import com.example.lib.libMapper.dtos.StudentSlimDto;
import com.example.lib.model.Book;

import java.util.List;

public interface IBookService {
    Book createBook(Book book);
    Book getBookById(long id);

    List<Book> getAllBooks();

    Book changeBookStatus(String title, boolean status);

    Book borrowBook(String title, StudentSlimDto studentSlimDto);
}
