package com.km.lms.controller;

import com.km.lms.model.Book;
import com.km.lms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class bookController {
    @Autowired
    BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("{id}")
    public Book getBook(@PathVariable("id") Long id) {
        return bookService.getBook(id);
    }

    @PostMapping
    public String createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping("{id}")
    public String updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        return bookService.deleteBook(id);
    }
}
