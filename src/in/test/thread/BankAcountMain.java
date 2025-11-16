package in.test.thread;

public class BankAcountMain {
	
	public static void main(String[] args) {
		BankAccount account = new BankAccount();
		
		Runnable task = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				account.withdraw(10);
			}
		};
		
		Thread t1 = new Thread(task,account.getClass().getName()+"-1");
		Thread t2 = new Thread(task,account.getClass().getName()+"-2");
		t1.start();
		t2.start();
	}
}
