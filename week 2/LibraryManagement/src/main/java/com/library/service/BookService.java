package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter Injection for BookRepository
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: Injection complete. BookRepository is ready.");
    }

    public void addBook(String title) {
        System.out.println("BookService: Processing request to add book: " + title);
        bookRepository.saveBook(title);
    }
}
