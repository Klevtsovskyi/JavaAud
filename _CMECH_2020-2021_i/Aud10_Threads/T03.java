

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;


public class T03 
{

	public static void main(String[] args) 
	{
		int n = 10;
		long t1 = 1000; // milliseconds
		long t2 = 4000;
		
		BlockingQueue<String> queue = 
				new LinkedBlockingDeque<String>(1);
		Lock lock = new Lock();
		
		PutThread put = new PutThread(n, t1, queue, "Put", lock);
		GetThread get = new GetThread(n, t2, queue, "Get", lock);
		
		put.start();
		get.start();
		
		try
		{
			put.join();
			get.join();
		}
		catch (InterruptedException e)
		{
			System.err.println(e);
		}

	}

}


class PutThread extends Thread
{
	private int count;
	private long time;
	private BlockingQueue<String> queue;
	private Lock lock;
	
	PutThread(int count, long time, 
			BlockingQueue<String> queue,
			String name, Lock lock)
	{
		super(name);
		this.count = count;
		this.time = time;
		this.queue = queue;
		this.lock = lock;
	}
	
	public void run()
	{
		for (int i = 0; i < count; i++)
		{
			System.out.println("Creating message");
			try 
			{Thread.sleep(time);}
			catch (InterruptedException e)
			{System.err.println(e);}
			
			String message = "MESSAGE " + i;
			System.out.println(message + " created");
			
			if (queue.remainingCapacity() == 0)
			{
				if (!lock.isLocked())
					lock.lock();
				lock.acquire();
			}
			queue.add(message);
			System.out.println(message + " added to queue");
		}
	}
}


class GetThread extends Thread
{
	private int count;
	private long time;
	private BlockingQueue<String> queue;
	private Lock lock;
	
	GetThread(int count, long time, 
			BlockingQueue<String> queue,
			String name, Lock lock)
	{
		super(name);
		this.count = count;
		this.time = time;
		this.queue = queue;
		this.lock = lock;
	}
	
	public void run()
	{
		for (int i = 0; i < count; i++)
		{
			System.out.println("Waiting for message to extract");
			String message;
			
			try 
			{message = queue.take();}
			catch (InterruptedException e)
			{System.err.println(e); message = "FAIL";}
			if (lock.isLocked())
				lock.release();
			System.out.println(message + " extracted from queue");
			
			try 
			{Thread.sleep(time);}
			catch (InterruptedException e)
			{System.err.println(e);}
			
			System.out.println(">>> " + message);
		}
	}
}


class Lock
{
	private boolean locked = false;
	
	public synchronized void acquire()
	{
		while (locked)
		{
			try 
			{wait();}
			catch (InterruptedException e)
			{System.err.println(e);}
		}
		locked = true;
		System.out.println("Locked by " + 
		Thread.currentThread().getName());
		notify();
	}
	
	public synchronized void release()
	{
		while (!locked)
		{
			try 
			{wait();}
			catch (InterruptedException e)
			{System.err.println(e);}
		}
		locked = false;
		System.out.println("Released by " + 
		Thread.currentThread().getName());
		notify();
	}
	
	public boolean isLocked()
	{
		return locked;
	}
	
	public void lock()
	{
		System.out.println("Locked by " + 
		Thread.currentThread().getName());
		locked = true;
	}
}