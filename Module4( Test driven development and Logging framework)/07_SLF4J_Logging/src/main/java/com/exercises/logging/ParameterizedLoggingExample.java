package com.exercises.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public void logUserAction(String username, String action) {
        logger.info("User {} performed action: {}", username, action);
    }

    public void logTransaction(String userId, double amount, String currency) {
        logger.debug("Transaction for user {}: {} {}", userId, amount, currency);
    }

    public void logError(String operation, Exception e) {
        logger.error("Operation {} failed with exception: {}", operation, e.getMessage());
    }

    public static void main(String[] args) {
        ParameterizedLoggingExample example = new ParameterizedLoggingExample();
        example.logUserAction("john_doe", "login");
        example.logTransaction("user123", 250.50, "USD");
        example.logError("database_connect", new RuntimeException("Connection refused"));
    }
}
