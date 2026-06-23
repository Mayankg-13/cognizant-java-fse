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
  cd "week 1/SingletonPatternExample"
  javac Logger.java SingletonTest.java
  java SingletonTest
  ```
- **Output Screenshot:**
  ![Singleton Test Output](./week%201/SingletonPatternExample/singleton_win.png)

#### [Exercise 2: Implementing the Factory Method Pattern](./week 1/FactoryMethodPatternExample)
- **Scenario:** Develop a document management system that creates different types of documents (e.g., Word, PDF, Excel) using the Factory Method pattern.
- **Implementation Details:**
  - **Document interface** declaring common operations: `open()`, `save()`, and `close()`.
  - **Concrete Documents** (`WordDocument`, `PdfDocument`, `ExcelDocument`) implementing specific behaviors for each document type.
  - **Abstract DocumentFactory** declaring the creator method `createDocument()`.
  - **Concrete Factories** (`WordDocumentFactory`, `PdfDocumentFactory`, `ExcelDocumentFactory`) overriding `createDocument()` to return instances of their respective documents.
- **How to Compile and Run:**
  ```powershell
  cd "week 1/FactoryMethodPatternExample"
  javac *.java
  java FactoryMethodTest
  ```
- **Output Screenshot:**
  ![Factory Method Test Output](./week%201/FactoryMethodPatternExample/factory_win.png)

### Data Structures and Algorithms

#### [Exercise 2: E-commerce Platform Search Function](./week 1/ECommercePlatformSearch)
- **Scenario:** Optimize the search functionality of an e-commerce platform for fast performance by implementing Linear and Binary Search.
- **Implementation Details:**
  - **Product class** defining search attributes: `productId`, `productName`, and `category`.
  - **Linear Search** matching target product IDs sequentially in O(N) worst-case complexity.
  - **Binary Search** matching target product IDs on a sorted array in O(log N) worst-case complexity.
  - **Big O & Suitability analysis** documented in the project's folder.
- **How to Compile and Run:**
  ```powershell
  cd "week 1/ECommercePlatformSearch"
  javac *.java
  java SearchTest
  ```
- **Output Screenshot:**
  ![Search Test Output](./week%201/ECommercePlatformSearch/search_win.png)

#### [Exercise 7: Financial Forecasting](./week 1/FinancialForecasting)
- **Scenario:** Develop a financial forecasting tool that predicts future values based on past growth rates using recursive and optimized approaches.
- **Implementation Details:**
  - **Naive Recursion** to project future value based on constant growth rate.
  - **Memoized Recursion** to optimize calculations using an array cache.
  - **Iterative Approach** to calculate values in $O(1)$ auxiliary space, avoiding call stack limitations.
  - **Varying Growth Rates** implementation recursively mapping sequential historical growth rates to projected values.
- **How to Compile and Run:**
  ```powershell
  cd "week 1/FinancialForecasting"
  javac *.java
  java ForecastingTest
  ```
- **Output Screenshot:**
  ![Financial Forecasting Output](./week%201/FinancialForecasting/forecasting_win.png)

### PL/SQL

#### [Exercise 1: Control Structures](./week 1/ControlStructures)
- Scenario: Implement control structures to apply discounts, update customer statuses, and generate reminders.
  - Scenario 1: Loop through all customers and apply a 1% discount to loan interest rates for customers over 60 years old.
  - Scenario 2: Iterate through customers and set `IsVIP` to `'TRUE'` for those with a balance over $10,000.
  - Scenario 3: Fetch loans due in the next 30 days and print reminder messages.
- How to Execute:
  - Run `schema.sql` to initialize the database tables and insert sample records.
  - Run the anonymous blocks `Scenario1.sql`, `Scenario2.sql`, and `Scenario3.sql` in your Oracle SQL client.
- Output Screenshot:
  ![Control Structures Output](./week%201/ControlStructures/control_structures_win.png)

#### [Exercise 3: Stored Procedures](./week 1/StoredProcedures)
- **Scenario:** Implement stored procedures to apply monthly interest to savings accounts, apply departmental employee bonuses, and securely transfer funds between accounts.
  - Scenario 1: Write a stored procedure `ProcessMonthlyInterest` that updates all savings account balances by adding 1% interest.
  - Scenario 2: Write a stored procedure `UpdateEmployeeBonus` that updates employee salaries in a given department by a given percentage parameter.
  - Scenario 3: Write a stored procedure `TransferFunds` that transfers a specified amount between two accounts, validating balances and ensuring safe concurrency.
- **How to Execute:**
  - Run `schema.sql` to initialize the database tables and insert sample records.
  - Run the scripts `Scenario1.sql`, `Scenario2.sql`, and `Scenario3.sql` in your Oracle SQL client.
- **Output Screenshot:**
  ![Stored Procedures Output](./week%201/StoredProcedures/stored_procedures_win.png)

### Unit Testing

#### [Exercise 1: Setting Up JUnit](./week 1/JUnitBasicExercises)
- **Scenario:** Set up a Java project to write unit tests using JUnit 4.
- **Implementation Details:**
  - **Setup and Teardown Fixtures:** `@Before` and `@After` annotations to instantiate and clean up resources before/after each test.
  - **Various Assertions:** Utilizing JUnit assertions (`assertEquals`, `assertTrue`, `assertFalse`, `assertNull`, `assertNotNull`) to validate test outcomes.
  - **Arrange-Act-Assert (AAA) Pattern:** Organizing test cases into distinct Arrange, Act, and Assert steps.
- **How to Compile and Run:**
  ```powershell
  cd "week 1/JUnitBasicExercises"
  python run.py
  ```
- **Output Screenshot:**
  ![JUnit Basic Tests Output](./week%201/JUnitBasicExercises/junit_basic_win.png)


