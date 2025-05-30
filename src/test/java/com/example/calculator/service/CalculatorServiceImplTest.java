package com.example.calculator.service;

import com.example.calculator.dto.*;
import com.example.calculator.service.impl.CalculatorServiceImpl;
import com.example.calculator.strategy.impl.*;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceImplTest {
    private CalculatorService service;

    @BeforeEach
    void setUp() {
        Calculator calculator = new Calculator(List.of(
                new AdditionStrategy(),
                new SubtractionStrategy(),
                new MultiplicationStrategy(),
                new DivisionStrategy()
        ));
        service = new CalculatorServiceImpl(calculator);
    }

    @Test
    void testSingleAddRequest() {
        CalculateRequest request = new CalculateRequest();
        request.setNum1(new BigDecimal("7"));
        request.setNum2(new BigDecimal("2"));
        request.setOperation("ADD");

        BigDecimal result = service.calculate(request);
        assertEquals(new BigDecimal("9.0"), result);
    }

    @Test
    void testChainCalculation() {
        ChainRequest request = new ChainRequest();
        request.setInitial(new BigDecimal("10"));
        request.setSteps(List.of(
                new ChainRequest.OperationStep("SUBTRACT", new BigDecimal("3")),
                new ChainRequest.OperationStep("MULTIPLY", new BigDecimal("2"))
        ));

        BigDecimal result = service.chainCalculate(request);
        assertEquals(new BigDecimal("14.0"), result);
    }

    @Test
    void testUnsupportedOperation() {
        CalculateRequest request = new CalculateRequest();
        request.setNum1(new BigDecimal("1"));
        request.setNum2(new BigDecimal("2"));
        request.setOperation("MOD");

        assertThrows(IllegalArgumentException.class, () -> service.calculate(request));
    }
}
