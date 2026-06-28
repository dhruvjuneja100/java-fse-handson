package com.exercises;

import com.exercises.checker.EvenCheckerTest;
import com.exercises.exception.ExceptionThrowerTest;
import com.exercises.performance.PerformanceTesterTest;
import com.exercises.calculator.OrderedTests;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        EvenCheckerTest.class,
        ExceptionThrowerTest.class,
        PerformanceTesterTest.class,
        OrderedTests.class
})
class AllTests {
}
