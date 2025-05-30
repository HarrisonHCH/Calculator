package com.example.calculator.strategy;

import java.math.BigDecimal;


public interface OperationStrategy {
    String getOperation();
    BigDecimal calculate(BigDecimal a, BigDecimal b);
}
