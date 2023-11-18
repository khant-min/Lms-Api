package com.km.lms.service;

import com.km.lms.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public List<Book> getAllBooks();
    public Book getBook(Long id);
    public String createBook(Book book);
    public String updateBook(Long id, Book book);
    public String deleteBook(Long id);
}
