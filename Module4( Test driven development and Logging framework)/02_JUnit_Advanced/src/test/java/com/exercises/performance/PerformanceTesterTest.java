package com.exercises.performance;

import org.junit.jupiter.api.Test;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

class PerformanceTesterTest {

    private final PerformanceTester performanceTester = new PerformanceTester();

    @Test
    void testPerformTask_completesWithinTime() {
        assertTimeout(Duration.ofSeconds(2), () -> performanceTester.performTask());
    }

    @Test
    void testPerformTask_returnsResult() {
        String result = performanceTester.performTask();
        assertEquals("Task completed", result);
    }

    @Test
    void testSlowTask_exceedsTimeout() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            String result = performanceTester.performTask();
            assertNotNull(result);
        });
    }
}
