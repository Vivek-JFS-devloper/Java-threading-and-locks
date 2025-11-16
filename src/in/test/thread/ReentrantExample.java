package in.test.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {

	private Lock lock = new ReentrantLock();

	public void outerMethod() {
		lock.lock();

		try {
			System.err.println("outerMethod Lock...");
			innerMethod();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			lock.unlock();
		}
 
	}

	public void innerMethod() {
		lock.lock();
		try {
			System.err.println("innerMethod Lock...");
			//outerMethod();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			lock.unlock();
			//lock.unlock();
		}

	}

	public static void main(String[] args) {
		ReentrantExample example = new ReentrantExample();
		example.outerMethod();
	}

}
