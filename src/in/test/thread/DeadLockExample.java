package in.test.thread;

public class DeadLockExample {
	public static void main(String[] args) {
		Pan pan = new Pan();
		Paper paper = new Paper();

		Thread t1 = new Thread(new Task1(pan, paper), "Thread-1");
		Thread t2 = new Thread(new Task2(pan, paper), "Thread-2");

		t1.start();
		t2.start();
	}
}

class Pan {
	public synchronized void writeWithPanAndPaper(Paper paper) {
		System.out.println(Thread.currentThread().getName() + " using pen " + this + " and try to write");
		paper.finishWriting();
	}

	public synchronized void finishWriting() {
		System.out.println(Thread.currentThread().getName() + " finished using pen " + this);
	}
}

class Paper {
	public synchronized void writeWithPanAndPaper(Pan pan) {
		System.out.println(Thread.currentThread().getName() + " using paper " + this + " and try to write");
		pan.finishWriting();
	}

	public synchronized void finishWriting() {
		System.out.println(Thread.currentThread().getName() + " finished using paper " + this);
	}
}

class Task1 implements Runnable {

	private final Pan pan;
	private final Paper paper;

	public Task1(Pan pan, Paper paper) {
		this.pan = pan;
		this.paper = paper;
	}

	@Override
	public void run() {
		pan.writeWithPanAndPaper(paper);

	}

}

class Task2 implements Runnable {

	private final Pan pan;
	private final Paper paper;

	public Task2(Pan pan, Paper paper) {
		this.pan = pan;
		this.paper = paper;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		paper.writeWithPanAndPaper(pan);

	}

}
