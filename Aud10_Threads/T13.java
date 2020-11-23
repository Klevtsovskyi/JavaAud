

import java.util.Date;
import java.util.concurrent.Semaphore;


public class T13 
{

	public static void main(String[] args) 
	{
		int n = 10;
		int t1 = 1;
		int t2 = 5;
		int t3 = 0;
		int t4 = 30;
		
		// Lock lock = new Lock();
		Semaphore lock = new Semaphore(1, true);
		Thread[] ths = new Thread[n];
		long start = (new Date()).getTime();
		
		for (int i = 0; i < n; i++)
		{
			long arriveTime = (long) 
					Math.floor((Math.random() * (t4 - t3) + t3) * 1000);
			long transitTime = (long) 
					Math.floor((Math.random() * (t2 - t1) + t1) * 1000);
			
			Train t = new Train(arriveTime,
					transitTime, i, lock, start);
			ths[i] = new Thread(t, "Train " + i);
			System.out.printf("Train %d arrives at %.3f "
					+ "and passes sector for %.3f\n",
					i, 
					(double) arriveTime / 1000,
					(double) transitTime / 1000);
			ths[i].start();
		}
		try
		{
			for (int i = 0; i < n; i++)
				ths[i].join();
		}
		catch (InterruptedException e)
		{
			System.err.println(e);
		}
	}

}


class Train implements Runnable
{
	private long arriveTime;
	private long transitTime;
	private int index;
	// private Lock lock;
	private Semaphore lock;
	private long start;
	
	Train(long arriveTime, long transitTime,
			int index, 
			// Lock lock,
			Semaphore lock,
			long start)
	{
		this.arriveTime = arriveTime;
		this.transitTime = transitTime;
		this.index = index;
		this.lock = lock;
		this.start = start;
	}
	
	public void run()
	{
		try
		{
			Thread.sleep(arriveTime);
			System.out.println("Train " + index +
					" has arrived to sector");
			lock.acquire();
			System.out.println("Train " + index +
					" passes the sector");
			Thread.sleep(transitTime);
			System.out.println("Train " + index +
					" passed the sector");
			lock.release();
		}
		catch (InterruptedException e) {}
		System.out.println("Train " + index + 
				" passed. Full time of travel: " +
				(((double) (new Date()).getTime() - start) / 1000) +
		" seconds");
	}
}