package com.example.calculator.dto;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.*;

public class ChainRequest {

    @NotNull
    private BigDecimal initial;

    @NotNull
    private List<OperationStep> steps;

    public BigDecimal getInitial() {
        return initial;
    }

    public void setInitial(BigDecimal initial) {
        this.initial = initial;
    }

    public List<OperationStep> getSteps() {
        return steps;
    }

    public void setSteps(List<OperationStep> steps) {
        this.steps = steps;
    }

    public static class OperationStep {


        @NotNull
        private String operation;

        @NotNull
        private BigDecimal operand;


        public String getOperation() {
            return operation;
        }

        public void setOperation(String operation) {
            this.operation = operation;
        }

        public BigDecimal getOperand() {
            return operand;
        }

        public void setOperand(BigDecimal operand) {
            this.operand = operand;
        }

        public OperationStep(String operation, BigDecimal operand) {
            this.operation = operation;
            this.operand = operand;
        }
    }
}