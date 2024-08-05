package com.aurionpro.test;

import com.aurionpro.model.Task;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuterService {
    public static void main(String[] args) {
//    	int coreCount = Runtime.getRuntime().availableProcessors();
//    	
//    	System.out.println("Number of avaiable processor "+coreCount);
//        ExecutorService service = Executors.newFixedThreadPool(coreCount);
        ExecutorService service = Executors.newCachedThreadPool();
        
        for (int i = 0; i < 100; i++) {
            service.submit(new Task());
        }

    }
}
