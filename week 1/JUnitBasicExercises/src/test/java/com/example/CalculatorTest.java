package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class CalculatorTest {
    private Calculator calculator;

    // Test Fixture: Setup before each test
    @Before
    public void setUp() {
        // Arrange
        calculator = new Calculator();
        System.out.println("Setup: Created Calculator instance.");
    }

    // Test Fixture: Teardown after each test
    @After
    public void tearDown() {
        calculator = null;
        System.out.println("Teardown: Released Calculator resources.");
    }

    // Exercise 2 & 4: Basic Tests using Arrange-Act-Assert (AAA)
    @Test
    public void testAdd() {
        // Act
        int result = calculator.add(10, 5);

        // Assert
        assertEquals(15, result);
        System.out.println("Test: testAdd passed.");
    }

    @Test
    public void testSubtract() {
        // Act
        int result = calculator.subtract(10, 5);

        // Assert
        assertEquals(5, result);
        System.out.println("Test: testSubtract passed.");
    }
}

