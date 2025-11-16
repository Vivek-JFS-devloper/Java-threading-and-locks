package in.test.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
	private double balance = 100;

	private final Lock lock = new ReentrantLock();

	public void withdraw(int amount) {

		try {
			System.out.println(Thread.currentThread().getName() + " attempting to withdraw: " + amount);
			if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {

				if (balance >= amount) {
					try {

						System.out.println(Thread.currentThread().getName() + " Proceeding with withdrawal...");
						Thread.sleep(2000);

						balance -= amount;
						System.out.println(Thread.currentThread().getName()
								+ " Completed withdrawal. Remaining balance: " + balance);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						lock.unlock();
					}

				} else {
					System.out.println(Thread.currentThread().getName() + " insufficient balance...");
				}
			}else {
				System.out.println(Thread.currentThread().getName() + " could not acquire the lock, will try again later...");
			}

		} catch (Exception ex) {

		}

	}
}
