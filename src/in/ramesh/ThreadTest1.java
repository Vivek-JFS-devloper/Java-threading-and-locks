package in.ramesh;

class Stack {
    int x;
    boolean flag = false;

    synchronized void push(int x) {
        while(flag) {
            try { wait(); } catch (InterruptedException e) {}
        }
        this.x = x;
        System.out.println(x + " is pushed");
        flag = true;
        notify();
    }

    synchronized int pop() {
        while(!flag) {
            try { wait(); } catch (InterruptedException e) {}
        }
        System.out.println(x + " is popped");
        flag = false;
        notify();
        return x;
    }
}

class A1 implements Runnable {
    Stack s1;
    A1(Stack s1, String name) {
        this.s1 = s1;
        new Thread(this, name).start();
    }
    public void run() {
        for(int i = 0; i < 7; i++) {
            s1.push(i);
        }
    }
}

class B1 implements Runnable {
    Stack s1;
    B1(Stack s1, String name) {
        this.s1 = s1;
        new Thread(this, name).start();
    }
    public void run() {
        for(int i = 0; i < 7; i++) {
            s1.pop();
        }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
        Stack s1 = new Stack();
        new A1(s1, "Producer");
        new B1(s1, "Consumer");
    }
}
