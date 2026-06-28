package com.exercises.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultiAppenderLoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(MultiAppenderLoggingExample.class);

    public void performOperations() {
        logger.debug("Debug message - detailed diagnostic info");
        logger.info("Info message - application started");
        logger.warn("Warning message - potential issue detected");
        logger.error("Error message - something went wrong");
    }

    public static void main(String[] args) {
        MultiAppenderLoggingExample example = new MultiAppenderLoggingExample();
        example.performOperations();
    }
}
