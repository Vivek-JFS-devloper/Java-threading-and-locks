package in.test.thread;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		/*
		 * MyThread t1 = new MyThread("MIN_PRIORITY "); MyThread t2 = new
		 * MyThread("MAX_PRIORITY "); MyThread t3 = new MyThread("NORM_PRIORITY ");
		 * 
		 * t1.setPriority(Thread.MIN_PRIORITY); t2.setPriority(Thread.MAX_PRIORITY);
		 * t3.setPriority(Thread.NORM_PRIORITY);
		 * 
		 * t1.start(); t2.start(); t3.start();
		 */
		
		Counter counter = new Counter();
		
		MainCounter t1 = new MainCounter(counter);
		MainCounter t2 = new MainCounter(counter);
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(counter.getCount());
	}
}
