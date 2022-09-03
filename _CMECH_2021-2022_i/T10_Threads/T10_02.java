import java.util.concurrent.Semaphore;


public class T10_02 {

	public static void main(String[] args) {
		int n = 10;
		long t1 = 1000;
		long t2 = 3000;
		long t3 = 0;
		long t4 = 20000;
		
		Semaphore semaphore = new Semaphore(1, true);
		Thread[] ths = new Thread[n];
		for (int i = 0; i < n; i++) {
			long arriveTime = (long) (Math.random() * (t4 - t3) + t3);
			long transitTime = (long) (Math.random() * (t2 - t1) + t1);
			ths[i] = new Thread(
				new Train(arriveTime, transitTime, semaphore), 
				"train " + i
			);
			System.out.printf(
				"Train %d arrives to the sector %6.3f "
				+ "and passes the sector for %6.3f\n",
				i, 
				arriveTime / 1000.0, 
				transitTime / 1000.0
			);
		}
		
		Log.print("Trains start moving");
		for (Thread th: ths)
			th.start();
		for (Thread th: ths) {
			try {
				th.join();
			} 
			catch (InterruptedException e) {e.printStackTrace();}
		}
		Log.print("All trains passed the sector");
	}

}


class Train implements Runnable {
	
	private long arriveTime;
	private long transitTime;
	private Semaphore semaphore;
	
	Train(long arriveTime, long transitTime, Semaphore semaphore) {
		this.arriveTime = arriveTime;
		this.transitTime = transitTime;
		this.semaphore = semaphore;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(arriveTime);
			Log.print("arrived to the sector");
			semaphore.acquire();
			Log.print("passes the sector");
			Thread.sleep(transitTime);
			semaphore.release();
			Log.print("passed the sector");
		} 
		catch (InterruptedException e) {e.printStackTrace();}
		System.out.printf(
			">>> %s passed the sector\n", Thread.currentThread().getName()
		);
	}
}
