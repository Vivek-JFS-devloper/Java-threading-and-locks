package in.ramesh.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
	private Integer balance = 100;
	private Lock lock = new ReentrantLock();

	public synchronized void withdraw(int amount) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " attempting to withdra " + amount);
		if (balance >= amount) {
			System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal");

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			balance -= amount;
			System.out.println(Thread.currentThread().getName() + " complete withdrawal. Remaining balance " + balance);
		} else {
			System.out.println(Thread.currentThread().getName() + " insufficient balance");
		}

	}

	public void widhrawal(int amount) throws InterruptedException{
		System.out.println(Thread.currentThread().getName() + " attempting to withdra " + amount);
		try {
			if (lock.tryLock(4000, TimeUnit.MILLISECONDS)) {

				if (balance >= amount) {
					try {
						System.out.println(Thread.currentThread().getName() + " Proceeding withdrowal");
						Thread.sleep(3000);
						balance -= amount;
						System.out.println(Thread.currentThread().getName() + " complete withdrawal. Remaining balance "
								+ balance);
					} catch (Exception ex) {
							Thread.currentThread().interrupt();
					} finally {
						lock.unlock();
					}
				} else {
					System.out.println(Thread.currentThread().getName() + " insufficient balance");
				}
			} else {
				System.out.println(Thread.currentThread().getName() + " could not acquire the lock, will try latter");	
			}
		} catch (InterruptedException e) {
				Thread.currentThread().interrupt(); 
		}
	}
}
