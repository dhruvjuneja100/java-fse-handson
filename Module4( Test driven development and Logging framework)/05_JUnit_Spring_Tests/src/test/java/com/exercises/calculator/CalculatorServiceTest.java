package com.exercises.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    void testAdd() {
        assertEquals(7, calculatorService.add(3, 4));
    }

    @Test
    void testAdd_negativeNumbers() {
        assertEquals(-1, calculatorService.add(-3, 2));
    }

    @ParameterizedTest
    @CsvSource({"1, 2, 3", "10, 20, 30", "-5, 5, 0", "100, 200, 300"})
    void testAdd_parameterized(int a, int b, int expected) {
        assertEquals(expected, calculatorService.add(a, b));
    }
}
