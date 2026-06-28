package com.exercises.logging;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoggingExampleTest {

    private final LoggingExample loggingExample = new LoggingExample();
    private final ParameterizedLoggingExample paramLogging = new ParameterizedLoggingExample();
    private final MultiAppenderLoggingExample multiAppender = new MultiAppenderLoggingExample();

    @Test
    void testLogError_doesNotThrow() {
        assertDoesNotThrow(() -> loggingExample.logError("Test error message"));
    }

    @Test
    void testLogWarn_doesNotThrow() {
        assertDoesNotThrow(() -> loggingExample.logWarn("Test warning message"));
    }

    @Test
    void testParameterizedLogging_userAction() {
        assertDoesNotThrow(() -> paramLogging.logUserAction("john_doe", "login"));
    }

    @Test
    void testParameterizedLogging_transaction() {
        assertDoesNotThrow(() -> paramLogging.logTransaction("user123", 250.50, "USD"));
    }

    @Test
    void testParameterizedLogging_error() {
        assertDoesNotThrow(() ->
                paramLogging.logError("db_connect", new RuntimeException("Connection refused"))
        );
    }

    @Test
    void testMultiAppenderLogging_allLevels() {
        assertDoesNotThrow(() -> multiAppender.performOperations());
    }
}
