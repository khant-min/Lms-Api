package com.km.lms.service.implementations;

import com.km.lms.model.Book;
import com.km.lms.repository.BookRepository;
import com.km.lms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public String createBook(Book book) {
         bookRepository.save(book);
         return "Created successfully";
    }

    @Override
    public String updateBook(Long id, Book book) {
        Book targetBook = bookRepository.findById(id).get();
//        if (Objects.nonNull(book.getBookName()) && !"".equalsIgnoreCase(book.getBookName())) {
//            targetBook.setBookName(book.getBookName());
//        }
//        if (Objects.nonNull(book.getAuthorName()) && !"".equalsIgnoreCase(book.getAuthorName())) {
//            targetBook.setAuthorName(book.getAuthorName());
//        }
//        if (Objects.nonNull(book.getBookRentalValue()) && !"".equalsIgnoreCase(book.getBookRentalValue())) {
//            targetBook.setBookRentalValue(book.getBookRentalValue());
//        }
        targetBook.setBookName(book.getBookName());
        targetBook.setAuthorName(book.getAuthorName());
        targetBook.setBookRentalValue(book.getBookRentalValue());
        bookRepository.save(targetBook);
        return "Updated successfully";
    }

    @Override
    public String deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
        return "Deleted Successfully";
    }
}
