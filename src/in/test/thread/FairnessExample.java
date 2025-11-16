package in.test.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairnessExample {

	private final Lock lock = new ReentrantLock(true);

	public void accessResource() {
		 lock.lock();
		// if (lock.tryLock()) {
		try {

			System.out.println(Thread.currentThread().getName() + " acquired the lock..");
			Thread.sleep(2000);
		} catch (Exception ex) {
			ex.printStackTrace();
			Thread.currentThread().interrupt();
		} finally {

			System.out.println(Thread.currentThread().getName() + " release the lock...");
			lock.unlock();
		}

	}

	public static void main(String[] args) {
		FairnessExample example = new FairnessExample();
		Runnable task = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				example.accessResource();
			}
		};

		Thread t1 = new Thread(task, "Thread-1");
		Thread t2 = new Thread(task, "Thread-2");
		Thread t3 = new Thread(task, "Thread-3");

		t1.start();
		t2.start();
		t3.start();
	}
}
