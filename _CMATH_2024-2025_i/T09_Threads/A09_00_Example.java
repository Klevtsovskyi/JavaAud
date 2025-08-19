package T09_Threads;

public class A09_00_Example {

	public static void main(String[] args) {
		Thread th1 = new MyThread1();
		Thread th2 = new MyThread2();
		th1.setDaemon(true);
		th1.start();
		th2.start();
		
		try {
			// th1.join();
			th2.join();
		} catch (InterruptedException e) {}
		
		System.out.println("End");
	}
}
class MyThread1 extends Thread {
	
	@Override
	public void run() {
		for (int i = 1; i < 51; i++) {
			System.out.println(i);
			Thread.yield();
		}
	}
}
class MyThread2 extends Thread {
	
	@Override
	public void run() {
		for (int i = -1; i > -21; i--) {
			System.out.println(i);
			Thread.yield();
		}
	}
}