import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;


public class T10_01 {

	public static void main(String[] args) {
		
		int n = 10;
		long t1 = 1000;
		long t2 = 2500;
		
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(n);
		Thread put = new Put(n, t1, queue, "put");
		Thread get = new Get(n, t2, queue, "get");
		
		Log.print("Program started");
		put.start();
		get.start();
		
		try {
			put.join();
			get.join();
		} 
		catch (InterruptedException e) {e.printStackTrace();}
		Log.print("Program ended");
	}

}


class Put extends Thread {
	
	private int count;
	private long procedureTime;
	private BlockingQueue<String> queue;
	
	Put(int count, long procedureTime, BlockingQueue<String> queue, String name) {
		super(name);
		this.count = count;
		this.procedureTime = procedureTime;
		this.queue = queue;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < count; i++) {
			String message = "MESSAGE" + i;
			try {
				Log.print(message + " is creating");
				Thread.sleep(procedureTime);
				queue.put(message);
				Log.print(message + " added to queue");
			} 
			catch (InterruptedException e) {e.printStackTrace();}
		}
	}
}


class Get extends Thread {
	
	private int count;
	private long procedureTime;
	private BlockingQueue<String> queue;
	
	Get(int count, long procedureTime, BlockingQueue<String> queue, String name) {
		super(name);
		this.count = count;
		this.procedureTime = procedureTime;
		this.queue = queue;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < count; i++) {
			String message = "";
			try {
				message = queue.take();
				Log.print(message + " extracted from queue");
				Thread.sleep(procedureTime);
				Log.print(message + " processed");
			} 
			catch (InterruptedException e) {e.printStackTrace();}
			System.out.println(">>> " + message);
		}
	}
}
