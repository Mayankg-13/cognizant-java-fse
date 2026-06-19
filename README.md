# Cognizant Java FSE - Design Patterns

This repository contains exercises completed as part of the Cognizant Java Full Stack Engineering (FSE) Deepskill Program.

## Exercises

### Creational Design Patterns

#### [Exercise 1: Implementing the Singleton Pattern](./Week_1_Design_Patterns/SingletonPatternExample)
- **Scenario:** Ensure a logging utility class (`Logger`) has only one instance throughout the application lifecycle to ensure consistent logging.
- **Implementation Details:**
  - **Private constructor** to prevent external instantiation.
  - **Static member variable** to hold the single instance of the class.
  - **Thread-Safe Double-Checked Locking** inside `getInstance()` to ensure lazy initialization works correctly in a multi-threaded environment.
  - **Reflection Guard** in the constructor to protect against reflection-based instantiations.
- **How to Compile and Run:**
  ```powershell
  cd Week_1_Design_Patterns/SingletonPatternExample/src
  javac Logger.java SingletonTest.java
  java SingletonTest
  ```
