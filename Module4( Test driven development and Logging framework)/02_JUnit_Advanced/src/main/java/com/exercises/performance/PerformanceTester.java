package com.exercises.performance;

public class PerformanceTester {

    public String performTask() {
        return "Task completed";
    }

    public void performSlowTask() throws InterruptedException {
        Thread.sleep(5000);
    }
}
