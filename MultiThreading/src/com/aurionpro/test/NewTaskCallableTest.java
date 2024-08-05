package com.aurionpro.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;	

import com.aurionpro.model.NewTask;

public class NewTaskCallableTest {
	public static void main(String[] args) {
		
        ExecutorService service = Executors.newCachedThreadPool();
        
        List<NewTask> tasks = new ArrayList<NewTask>();
        tasks.add(new NewTask());
        tasks.add(new NewTask());
        tasks.add(new NewTask());
        tasks.add(new NewTask());
        tasks.add(new NewTask());
        
		try {
			List<Future<Integer>> futures = service.invokeAll(tasks); 
			for (Future<Integer> future : futures) {
				
				System.out.println(future.get());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch blocks
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
