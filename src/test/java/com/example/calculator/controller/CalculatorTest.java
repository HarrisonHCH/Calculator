package com.example.calculator.controller;

import com.example.calculator.operation.Operation;
import com.example.calculator.service.Calculator;
import com.example.calculator.strategy.impl.*;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator(List.of(
                new AdditionStrategy(),
                new SubtractionStrategy(),
                new MultiplicationStrategy(),
                new DivisionStrategy()
        ));
    }

    @Test
    void testAddition() {
        BigDecimal result = calculator.calculate(Operation.ADD, 3, 5);
        assertEquals(new BigDecimal("8.0"), result);
    }

    @Test
    void testDivisionWithPrecision() {
        BigDecimal result = calculator.calculate(Operation.DIVIDE, 10, 3);
        assertEquals(new BigDecimal("3.3"), result);
    }

    @Test
    void testDivisionByZeroThrowsException() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(Operation.DIVIDE, 5, 0));
    }

    @Test
    void testNullInputThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(null, 5, 3));
    }
}
