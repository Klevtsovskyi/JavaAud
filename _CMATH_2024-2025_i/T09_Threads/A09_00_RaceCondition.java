package T09_Threads;

import java.util.concurrent.atomic.AtomicInteger;

public class A09_00_RaceCondition {
	
//	static public int n = 0;
	static public AtomicInteger n = new AtomicInteger(0);
	
	public static void main(String[] args) {
		Thread th1 = new Thread(new MyThread());
		Thread th2 = new Thread(new MyThread());

		th1.start();
		th2.start();
		
		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {}
		
		System.out.println(n);
	}
	
}

class MyThread implements Runnable {
	
	static public void addOne() {
//		A09_00_RaceCondition.n = A09_00_RaceCondition.n + 1;
		A09_00_RaceCondition.n.addAndGet(1);
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000000; i++) {
			addOne();
		}
	}
	
}