package in.ramesh.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BlockingThread {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		Future<Integer> future = executorService.submit(()->{
			try {
				Thread.sleep(2000);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 20;
		});
		System.out.println("Waiting for result...");
		Integer result = future.get();
		System.out.println("Result: "+result);
		
	}
}
