package com.example.calculator.strategy.impl;

import com.example.calculator.strategy.OperationStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class DivisionStrategy implements OperationStrategy {

    @Override
    public String getOperation() {
        return "DIVIDE";
    }

    @Override
    public BigDecimal calculate(BigDecimal a, BigDecimal b) {
        if (b.compareTo(BigDecimal.ZERO) == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a.divide(b, 10, RoundingMode.HALF_UP);  // 保留 10 位小数
    }
}
