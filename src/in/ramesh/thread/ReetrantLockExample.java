package in.ramesh.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReetrantLockExample {
	private Lock lock = new ReentrantLock();

	public void outerMethod() {
		lock.lock();
		try {

			System.out.println("outer Method");
			innerMethod();

		} catch (Exception ex) {

		} finally {
			lock.unlock();
		}
	}

	public void innerMethod() {
		lock.lock();
		try {
			System.out.println("inner Method");

		} catch (Exception ex) {

		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		ReetrantLockExample r = new ReetrantLockExample();
		r.outerMethod();
	}
}
