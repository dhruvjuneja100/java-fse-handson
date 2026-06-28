package com.exercises.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExceptionThrowerTest {

    private final ExceptionThrower exceptionThrower = new ExceptionThrower();

    @Test
    void testThrowException() {
        assertThrows(IllegalArgumentException.class, exceptionThrower::throwException);
    }

    @Test
    void testThrowException_messageVerification() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                exceptionThrower::throwException
        );
        assertEquals("Expected exception", ex.getMessage());
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> exceptionThrower.divide(10, 0));
    }

    @Test
    void testDivideSuccess() {
        assertEquals(5, exceptionThrower.divide(10, 2));
    }
}
