package com.example.calculator.service.impl;

import com.example.calculator.dto.CalculateRequest;
import com.example.calculator.dto.ChainRequest;
import com.example.calculator.operation.Operation;
import com.example.calculator.service.Calculator;
import com.example.calculator.service.CalculatorService;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class CalculatorServiceImpl implements CalculatorService {
    private final Calculator calculator;

    public CalculatorServiceImpl(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public BigDecimal calculate(CalculateRequest request) {
        Operation op = Operation.valueOf(request.getOperation().toUpperCase());
        return calculator.calculate(op, request.getNum1(), request.getNum2());
    }

    @Override
    public BigDecimal chainCalculate(ChainRequest request) {
        BigDecimal result = request.getInitial();

        for (ChainRequest.OperationStep step : request.getSteps()) {
            Operation op = Operation.valueOf(step.getOperation().toUpperCase());
            result = calculator.calculate(op, result, step.getOperand());
        }

        return result;
    }
}
