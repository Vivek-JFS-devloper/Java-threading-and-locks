package in.ramesh.thread;

import java.util.concurrent.CompletableFuture;

public class NoBlockingThreads {
	public static void main(String[] args) {
		/*
		 * CompletableFuture .supplyAsync(() -> { try { Thread.sleep(2000); // Simulate
		 * long-running task } catch (InterruptedException e) { e.printStackTrace(); }
		 * return "Result from async task"; }) .thenAccept(result ->
		 * System.out.println(result));
		 * 
		 * System.out.println("Main thread is free to do other work...");
		 * 
		 * try { Thread.sleep(3000); // Keep JVM alive long enough for async task to
		 * complete } catch (InterruptedException e) { e.printStackTrace(); }
		 */

		CompletableFuture
				.supplyAsync(() -> " Data from DB")
				.thenApply(data -> data.toUpperCase())
				.thenAccept(System.out::println);

		System.out.println("hello");

	}
}
