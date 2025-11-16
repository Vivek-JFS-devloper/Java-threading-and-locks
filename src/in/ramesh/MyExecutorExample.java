package in.ramesh;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Using ExecutorService with Runnable
public class MyExecutorExample {
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(1);
		
		Runnable task1 = ()->System.out.println("run task 1");
		Runnable task2 = ()->System.out.println("run task 2");
		
		executor.submit(task1);
		executor.submit(task2);
		
		executor.shutdown();
	}

}
