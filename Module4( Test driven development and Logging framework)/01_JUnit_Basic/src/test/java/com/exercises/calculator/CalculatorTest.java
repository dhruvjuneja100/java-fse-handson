package com.exercises.calculator;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        calculator = null;
    }

    @Test
    void testAdd() {
        int result = calculator.add(2, 3);
        assertEquals(5, result);
    }

    @Test
    void testSubtract() {
        int result = calculator.subtract(10, 4);
        assertEquals(6, result);
    }

    @Test
    void testMultiply() {
        int result = calculator.multiply(3, 4);
        assertEquals(12, result);
    }

    @Test
    void testDivide() {
        double result = calculator.divide(10, 2);
        assertEquals(5.0, result);
    }

    @Test
    void testAssertions() {
        assertEquals(5, 2 + 3);
        assertTrue(5 > 3);
        assertFalse(5 < 3);
        assertNull(null);
        assertNotNull(new Object());
    }

    @Test
    void testAddUsingAAAPattern() {
        // Arrange
        int a = 4;
        int b = 6;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(10, result);
    }

    @Test
    void testDivideByZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }
}
