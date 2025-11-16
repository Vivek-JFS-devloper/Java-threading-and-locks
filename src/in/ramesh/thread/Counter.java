package in.ramesh.thread;

public class Counter {
	private int count;
	
	public void increment() {
		try {
			Thread.sleep(3000);
			count++;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int getCount() {
		return count;
	}
}
