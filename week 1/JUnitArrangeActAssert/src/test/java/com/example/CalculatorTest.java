package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class CalculatorTest {
    private Calculator calculator;

    // Test Fixture Setup: Executed before each test case
    @Before
    public void setUp() {
        // Arrange
        calculator = new Calculator();
        System.out.println("Setup: Created a new Calculator instance.");
    }

    // Test Fixture Teardown: Executed after each test case
    @After
    public void tearDown() {
        calculator = null;
        System.out.println("Teardown: Cleared Calculator instance resources.");
    }

    @Test
    public void testAdd() {
        // Arrange
        int number1 = 15;
        int number2 = 10;

        // Act
        int result = calculator.add(number1, number2);

        // Assert
        assertEquals(25, result);
        System.out.println("Ran testAdd: 15 + 10 = " + result);
    }

    @Test
    public void testSubtract() {
        // Arrange
        int number1 = 30;
        int number2 = 12;

        // Act
        int result = calculator.subtract(number1, number2);

        // Assert
        assertEquals(18, result);
        System.out.println("Ran testSubtract: 30 - 12 = " + result);
    }

    @Test
    public void testMultiply() {
        // Arrange
        int number1 = 6;
        int number2 = 7;

        // Act
        int result = calculator.multiply(number1, number2);

        // Assert
        assertEquals(42, result);
        System.out.println("Ran testMultiply: 6 * 7 = " + result);
    }

    @Test
    public void testDivide() {
        // Arrange
        int number1 = 20;
        int number2 = 5;

        // Act
        double result = calculator.divide(number1, number2);

        // Assert
        assertEquals(4.0, result, 0.0001);
        System.out.println("Ran testDivide: 20 / 5 = " + result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        // Arrange
        int number1 = 20;
        int number2 = 0;

        // Act & Assert (JUnit 4 expected exception acts as the assertion)
        calculator.divide(number1, number2);
        System.out.println("Ran testDivideByZero: Exception expected.");
    }
}
