package com.example.calculator.strategy.impl;

import com.example.calculator.strategy.OperationStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class MultiplicationStrategy implements OperationStrategy {
    @Override
    public String getOperation() {
        return "MULTIPLY";
    }

    @Override
    public BigDecimal calculate(BigDecimal a, BigDecimal b) {
        return a.multiply(b);
    }
}
