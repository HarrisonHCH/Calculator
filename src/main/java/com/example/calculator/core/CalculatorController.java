package com.example.calculator.core;

import com.example.calculator.dto.CalculateRequest;
import com.example.calculator.dto.ChainRequest;
import com.example.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/v1/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/calculate")
    public BigDecimal calculate(@RequestBody CalculateRequest request) {
        return calculatorService.calculate(request);
    }


    @PostMapping("/chain")
    public BigDecimal chainCalculate(@RequestBody ChainRequest request) {
        return calculatorService.chainCalculate(request);
    }
}
