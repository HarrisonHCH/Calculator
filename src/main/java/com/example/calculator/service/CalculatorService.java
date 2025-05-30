package com.example.calculator.service;

import com.example.calculator.dto.CalculateRequest;
import com.example.calculator.dto.ChainRequest;

import java.math.BigDecimal;

public interface CalculatorService {
    BigDecimal calculate(CalculateRequest request);

    BigDecimal chainCalculate(ChainRequest request);

}
