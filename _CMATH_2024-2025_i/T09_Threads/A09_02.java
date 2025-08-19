package T09_Threads;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

/*
 * Залізниця має одноколійну ділянку. Цю ділянку потяги проходять за деякий
випадковий час у діапазоні від T1 до T2. Якщо у момент підходу нового потяга
одноколійна ділянка зайнята, потяг чекає її звільнення. Промоделювати рух
потягів, вважаючи, що наступний потяг підходить до ділянки через
випадковий інтервал часу від T3 до T4. Кожен потяг – це 1 потік.
 */
public class A09_02 {

	public static void main(String[] args) {
		double T1 = 3.0;
		double T2 = 6.0;
		double T3 = 0.0;
		double T4 = 30.0;
		int n = 10;
		Lock lock = new ReentrantLock(true);
		
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
	}
	
	public static void train(long arrive, long transit, int i, Lock lock) {
		Thread.currentThread().setName("Train " + i);
		try {
			Thread.sleep(arrive);
			Log.print("has arrived");
			lock.lock();
			Log.print("starts passing the sector");
			Thread.sleep(transit);
			lock.unlock();
			Log.print("passed the sector");
		}
		catch (InterruptedException e) {}
	}
}
