package in.ramesh.thread;

public class Main {
	public static void main(String[] args) {
		BankAccount sbi = new BankAccount();
		
		Runnable r1 = new Runnable() {
			
			@Override
			public void run() {
					
				try {
					//sbi.withdraw(50);
					sbi.widhrawal(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Thread t1 = new Thread(r1,"Thread-1");
		Thread t2 = new Thread(r1,"Thread-2");
		
		t1.start();
		t2.start();
	}
}
