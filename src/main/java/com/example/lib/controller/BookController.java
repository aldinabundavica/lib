package com.example.lib.controller;

import com.example.lib.libMapper.dtos.StudentSlimDto;
import com.example.lib.model.Book;
import com.example.lib.model.Student;
import com.example.lib.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.lib.helper.Constants.httpBlankSpace;

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
    public Book createBook(Book book) {
        return _bookService.createBook(book);
    }

    @GetMapping("book/{id}")
    @ResponseBody
    public Book getBookById(@PathVariable long id) {
        Book book = _bookService.getBookById(id);
        return book;
    }

    @GetMapping("/allBooks")
    public String getAllBooks(Model model) {
        List<Book> books = _bookService.getAllBooks();
        //model.addAttribute("listBooks", books);
        //List<Book> filteredBooks = _bookService.findBookByKeyword(keyword);
        model.addAttribute("listBooks", books);
        return "allBooks";
    }

    @PutMapping("/changebookstatus/{title}/{status}")
    public Book changeBookStatus(@PathVariable String title,@PathVariable boolean status) {
        title.replace(httpBlankSpace, " ");
        return _bookService.changeBookStatus(title, (boolean) status);
    }

    @PutMapping("/borrowBook/{title}")
    @ResponseBody
    public Book borrowBook(@PathVariable String title, @RequestBody StudentSlimDto studentSlimDto) {
        return _bookService.borrowBook(title, studentSlimDto);
    }
}
