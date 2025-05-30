package com.example.calculator.service;

import com.example.calculator.operation.Operation;
import com.example.calculator.strategy.OperationStrategy;
import com.example.calculator.util.Constants;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.*;

@Component
public class Calculator {
    private final Map<Operation, OperationStrategy> strategyMap;

    public Calculator(List<OperationStrategy> strategies) {
        this.strategyMap = strategies.stream()
                .collect(Collectors.toMap(
                        s -> Operation.valueOf(s.getOperation().toUpperCase()),
                        s -> s
                ));
    }

    public BigDecimal calculate(Operation op, Number num1, Number num2) {
        if (op == null || num1 == null || num2 == null) {
            throw new IllegalArgumentException("Operation and operands must not be null.");
        }

        OperationStrategy strategy = strategyMap.get(op);
        if (strategy == null) {
            throw new UnsupportedOperationException("Unsupported operation: " + op);
        }

        BigDecimal a = new BigDecimal(num1.toString());
        BigDecimal b = new BigDecimal(num2.toString());


        return strategy.calculate(a, b)
                .setScale(Constants.DEFAULT_SCALE, Constants.DEFAULT_ROUNDING);
    }
}
