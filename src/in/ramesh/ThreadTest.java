package in.ramesh;

public class ThreadTest {
	public static void main(String[] args) {
		Customer c = new Customer();

		// Thread for withdrawal
		new Thread(() -> {
			c.withdraw(2000);
		}).start();

		// Thread for deposit
		new Thread(() -> {
			try {
				Thread.sleep(1000); // simulate delay
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			c.deposit(500); // Try with smaller amount to test logic
		}).start();
	}
}

class Customer {
	int amount = 1000;

	public synchronized void withdraw(int amount) {
		System.out.println("Going to withdraw...");

		if (this.amount < amount) {
			System.out.println("Less balance; waiting for deposit...");
			try {
				wait();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		if (this.amount >= amount) {
			this.amount -= amount;
			System.out.println("Withdraw completed...");
		} else {
			System.out.println("Still insufficient balance. Withdraw failed.");
		}

		System.out.println("Your current balance is: " + this.amount);
	}

	public synchronized void deposit(int amount) {
		System.out.println("Going to deposit...");
		this.amount += amount;
		System.out.println("Deposit completed...");
		notify(); // notify the waiting withdraw thread
	}
}
