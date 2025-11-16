package in.test.thread;

public class Counter {

	private int count = 0;

	/*
	 * public synchronized void increment() { this.count++; }
	 */
	
	public void increment() {
		synchronized (this) {
			
			this.count++;
		}
	}

	public int getCount() {
		return count;
	}
}
