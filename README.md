# Cognizant Java FSE - Design Patterns

This repository contains exercises completed as part of the Cognizant Java Full Stack Engineering (FSE) Deepskill Program.

## Exercises

### Creational Design Patterns

#### [Exercise 1: Implementing the Singleton Pattern](./week 1/SingletonPatternExample)
- **Scenario:** Ensure a logging utility class (`Logger`) has only one instance throughout the application lifecycle to ensure consistent logging.
- **Implementation Details:**
  - **Private constructor** to prevent external instantiation.
  - **Static member variable** to hold the single instance of the class.
  - **Thread-Safe Double-Checked Locking** inside `getInstance()` to ensure lazy initialization works correctly in a multi-threaded environment.
  - **Reflection Guard** in the constructor to protect against reflection-based instantiations.
- **How to Compile and Run:**
  ```powershell
  cd week 1/SingletonPatternExample
  javac Logger.java SingletonTest.java
  java SingletonTest
  ```

#### [Exercise 2: Implementing the Factory Method Pattern](./week 1/FactoryMethodPatternExample)
- **Scenario:** Develop a document management system that creates different types of documents (e.g., Word, PDF, Excel) using the Factory Method pattern.
- **Implementation Details:**
  - **Document interface** declaring common operations: `open()`, `save()`, and `close()`.
  - **Concrete Documents** (`WordDocument`, `PdfDocument`, `ExcelDocument`) implementing specific behaviors for each document type.
  - **Abstract DocumentFactory** declaring the creator method `createDocument()`.
  - **Concrete Factories** (`WordDocumentFactory`, `PdfDocumentFactory`, `ExcelDocumentFactory`) overriding `createDocument()` to return instances of their respective documents.
- **How to Compile and Run:**
  ```powershell
  cd week 1/FactoryMethodPatternExample
  javac *.java
  java FactoryMethodTest
  ```

