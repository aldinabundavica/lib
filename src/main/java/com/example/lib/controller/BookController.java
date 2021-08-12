package com.example.lib.controller;

import com.example.lib.model.Book;
import com.example.lib.model.Student;
import com.example.lib.service.BookService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static com.example.lib.helper.Constants.httpBlankSpace;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookService _bookService;

    public BookController(BookService _bookService) {
        this._bookService = _bookService;
    }

    @PostMapping("/addBook")
    public Book createBook(@RequestBody Book book) {
        return _bookService.createBook(book);
    }

    @GetMapping("book/{id}")
    @ResponseBody
    public Book getBookById(@PathVariable long id) {
        return _bookService.getBookById(id);
    }

    @GetMapping("/allBooks")
    public List<Book> getAllBooks() {
        return _bookService.getAllBooks();
    }

    @PutMapping("/changebookstatus/{title}/{status}")
    public Book changeBookStatus(@PathVariable String title,@PathVariable boolean status) {
        title.replace(httpBlankSpace, " ");
        return _bookService.changeBookStatus(title, (boolean) status);
    }

    @PutMapping("/borrowBook/{title}/{studentname}/{studentlastname}")
    public Book borrowBook(@PathVariable String title, @PathVariable String studentname, @PathVariable String studentlastname) {

        title.replace(httpBlankSpace, " ");
        studentname.replace(httpBlankSpace, " ");
        studentlastname.replace(httpBlankSpace, " ");

        return _bookService.borrowBook(title, studentname, studentlastname);
    }

}
