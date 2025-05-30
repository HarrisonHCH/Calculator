package com.example.calculator.service.impl;

import com.example.calculator.dto.CalculateRequest;
import com.example.calculator.dto.ChainRequest;
import com.example.calculator.service.CalculatorService;
import com.example.calculator.strategy.OperationStrategy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.*;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    private final Map<String, OperationStrategy> strategyMap;

    public CalculatorServiceImpl(List<OperationStrategy> strategies) {
        // 将所有策略按名称映射为 Map，便于查找
        this.strategyMap = strategies.stream()
                .collect(Collectors.toMap(OperationStrategy::getOperation, s -> s));
    }

    @Override
    public BigDecimal calculate(CalculateRequest request) {
        OperationStrategy strategy = strategyMap.get(request.getOperation().toUpperCase());
        if (strategy == null) {
            throw new IllegalArgumentException("Unsupported operation: " + request.getOperation());
        }
        return strategy.calculate(request.getNum1(), request.getNum2());
    }

    @Override
    public BigDecimal chainCalculate(ChainRequest request) {
        BigDecimal result = request.getInitial();
        for (ChainRequest.OperationStep step : request.getSteps()) {
            OperationStrategy strategy = strategyMap.get(step.getOperation().toUpperCase());
            if (strategy == null) {
                throw new IllegalArgumentException("Unsupported operation: " + step.getOperation());
            }
            result = strategy.calculate(result, step.getOperand());
        }
        return result;
    }
}
