package com.aurionpro.bhavioural.strategy.model;

public class OperationStrategy {
    private IOperation operation;

    public OperationStrategy(IOperation operation) {
        this.operation = operation;
    }

    public IOperation getOperation() {
        return operation;
    }

    public void setOperation(IOperation operation) {
        this.operation = operation;
    }
    
    public void doOperation(int a, int b) {
        int result = operation.doOperation(a, b);
        System.out.println("Result: " + result);
    }
}
