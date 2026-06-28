package com.exercises.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        logger.error("This is an error message");
        logger.warn("This is a warning message");
    }

    public void logError(String message) {
        logger.error(message);
    }

    public void logWarn(String message) {
        logger.warn(message);
    }
}
