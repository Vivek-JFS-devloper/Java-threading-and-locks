package in.ramesh.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(3);

		for (int i = 0; i <= 3; i++) {
			new Thread(() -> {
				System.out.println(Thread.currentThread().getName() + " Finished word");
				latch.countDown();
			}).start();

		}
		latch.await();
		System.out.println("All task finish");
	}
}
