package com.example.lib.controller;

import com.example.lib.libMapper.dtos.StudentSlimDto;
import com.example.lib.model.Book;
import com.example.lib.model.Student;
import com.example.lib.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private BookService _bookService;
    public BookController(BookService _bookService) {
        this._bookService = _bookService;
    }

    @GetMapping("/add")
    public String showCreateBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("writers", _bookService.getAllWritersNames());
        return "addBook";
    }

    @PostMapping("/addBook")
    public String createBook(Book book) {
        if(_bookService.createBook(book) != null) {
            return "redirect:/books/allBooks";
        }
        return "";
    }

    @GetMapping("book/{id}")
    @ResponseBody
    public Book getBookById(@PathVariable long id) {
        Book book = _bookService.getBookById(id);
        return book;
    }

    @GetMapping("/allBooks")
    public String getAllBooks(Model model, String keyword) {
        model.addAttribute("listBooks", keyword == null ? _bookService.getAllBooks() : _bookService.findBookByKeyword(keyword));
        return "allBooks";
    }


    @PutMapping("/borrowBook/{title}")
    @ResponseBody
    public Book borrowBook(@PathVariable String title, @RequestBody StudentSlimDto studentSlimDto) {
        return _bookService.borrowBook(title, studentSlimDto);
    }
}
