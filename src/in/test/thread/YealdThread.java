package in.test.thread;

public class YealdThread extends Thread {

	public YealdThread(String name) {
		super(name);
	}

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {

			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
				//Thread.yield();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		YealdThread t1 = new YealdThread("T1");
		YealdThread t2 = new YealdThread("T2");
		t1.setDaemon(true);
		t1.start();
		//t1.yield();
		//t1.join();
		System.out.println("Done");
		t2.start();
		System.err.println("Done-1");
	}
}
