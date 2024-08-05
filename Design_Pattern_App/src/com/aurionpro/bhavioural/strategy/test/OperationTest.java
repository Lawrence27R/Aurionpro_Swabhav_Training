package com.aurionpro.bhavioural.strategy.test;

import com.aurionpro.bhavioural.strategy.model.AddOperation;
import com.aurionpro.bhavioural.strategy.model.MultiplyOperation;
import com.aurionpro.bhavioural.strategy.model.OperationStrategy;

public class OperationTest {
    public static void main(String[] args) {
        OperationStrategy op = new OperationStrategy(new AddOperation());
        op.doOperation(10, 2); 
        
        op.setOperation(new MultiplyOperation());
        op.doOperation(10, 2); 
    }
}
