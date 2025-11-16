package in.test.thread;

public class MainCounter extends Thread{

	private Counter counter;
	
	public MainCounter(Counter counter) {
		this.counter = counter;
	}
	
	@Override
	public  void run() {
		for(int i =0; i < 1000; i++) {
			counter.increment();
		}
	}

	
}
