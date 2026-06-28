package com.exercises.checker;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class EvenCheckerTest {

    private final EvenChecker evenChecker = new EvenChecker();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 100})
    void testIsEven_withEvenNumbers(int number) {
        assertTrue(evenChecker.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 99})
    void testIsEven_withOddNumbers(int number) {
        assertFalse(evenChecker.isEven(number));
    }

    @ParameterizedTest
    @CsvSource({"2, true", "3, false", "0, true", "7, false"})
    void testIsEven_withCsvSource(int number, boolean expected) {
        assertEquals(expected, evenChecker.isEven(number));
    }
}
