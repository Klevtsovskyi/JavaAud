package T09_Threads;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * В умовах задачі [A]09.02 вважати, що залізниця має N-колійну ділянку.
Обчислити кількість потягів, які прибудуть до ділянки в момент, коли вона
буде зайнята іншими потягами.
 */
public class A09_03 {
	
	public static AtomicInteger count = new AtomicInteger(0);

	public static void main(String[] args) {
		double T1 = 3.0;
		double T2 = 6.0;
		double T3 = 0.0;
		double T4 = 30.0;
		int n = 10;
		int N = 2;
		Semaphore lock = new Semaphore(N, true);
		
		Thread[] ths = new Thread[n];
		Log.print("Start");
		for (int i = 0; i < n; i++) {
			long arrive = (long) ((Math.random() * (T4 - T3) + T3) * 1000.0);
			long transit = (long) ((Math.random() * (T2 - T1) + T1) * 1000.0);
			int j = i;
			
			System.out.printf(
				"Train %d arrives at %6.3f and passes the sector for %6.3f\n",
				i, arrive / 1000.0, transit / 1000.0
			);
			ths[i] = new Thread(() -> train(arrive, transit, j, lock));
			ths[i].start();
		}
		
		try {
			for (int i = 0; i < n; i++) {
				ths[i].join();
			}
		}
		catch (InterruptedException e) {}
		Log.print("End");
		System.out.println("Count: " + count);
	}
	
	public static void train(long arrive, long transit, int i, Semaphore lock) {
		Thread.currentThread().setName("Train " + i);
		try {
			Thread.sleep(arrive);
			Log.print("has arrived");
			if (!lock.tryAcquire()) {
				count.addAndGet(1);
				lock.acquire();	
			}
			
			Log.print("starts passing the sector");
			Thread.sleep(transit);
			lock.release();
			Log.print("passed the sector");
		}
		catch (InterruptedException e) {}
	}
}
