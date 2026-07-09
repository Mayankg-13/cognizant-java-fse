package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Load the Spring Application Context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the BookService bean from the application context
        BookService bookService = (BookService) context.getBean("bookService");

        // Test the configuration by invoking business logic methods
        System.out.println("\n=======================================================");
        System.out.println("   Library Management System (Basic Spring XML Config) ");
        System.out.println("=======================================================");
        bookService.addBook("Introduction to Spring Framework");
        bookService.addBook("Effective Java (3rd Edition)");
        System.out.println("=======================================================\n");
    }
}
