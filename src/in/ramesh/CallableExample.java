package in.ramesh;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//Using Callable with Future
public class CallableExample {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Callable<String> task = ()-> "Hello callable inteface";
		
		Future<String> future = executor.submit(task);
		
		System.out.println(future.get());
		
		executor.shutdown();
	}
}
