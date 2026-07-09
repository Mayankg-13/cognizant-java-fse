package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Load the Spring Application Context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the BookService bean from the application context
        BookService bookService = (BookService) context.getBean("bookService");

        // Test the configuration and verify dependency injection
        System.out.println("\n=======================================================");
        System.out.println("  Library Management System (Dependency Injection Demo) ");
        System.out.println("=======================================================");
        bookService.addBook("Clean Code by Robert C. Martin");
        bookService.addBook("Design Patterns by Gang of Four");
        System.out.println("=======================================================\n");
    }
}
