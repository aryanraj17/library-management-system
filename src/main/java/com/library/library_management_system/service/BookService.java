package com.library.library_management_system.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.library.library_management_system.model.Book;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();

    public List<Book> getAllBooks() {
        return books;
    }

    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    public Book getBookById(Long id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public String deleteBook(Long id) {
        books.removeIf(book -> book.getId().equals(id));
        return "Book deleted successfully";
    }

    public Book issueBook(Long id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                book.setIssued(true);
                return book;
            }
        }
        return null;
    }

    public Book returnBook(Long id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                book.setIssued(false);
                return book;
            }
        }
        return null;
    }
}
