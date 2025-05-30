package com.example.calculator.dto;


import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public class CalculateRequest {

    @NotNull
    private BigDecimal num1;

    @NotNull
    private BigDecimal num2;

    @NotNull
    private String operation;

    public BigDecimal getNum1() {
        return num1;
    }

    public void setNum1(BigDecimal num1) {
        this.num1 = num1;
    }

    public BigDecimal getNum2() {
        return num2;
    }

    public void setNum2(BigDecimal num2) {
        this.num2 = num2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
