package com.exercises.calculator;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderedTests {

    private static int counter = 0;

    @Test
    @Order(1)
    void firstTest() {
        counter++;
        assertEquals(1, counter);
    }

    @Test
    @Order(2)
    void secondTest() {
        counter++;
        assertEquals(2, counter);
    }

    @Test
    @Order(3)
    void thirdTest() {
        counter++;
        assertEquals(3, counter);
    }
}
