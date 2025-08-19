package T09_Threads;

import java.util.concurrent.ArrayBlockingQueue;

/*
 * Один потік кожні T1 одиниць часу надає повідомлення. Інший потік має
обробити ці повідомлення. Обробка займає T2 одиниць часу. Скласти
програму, яка генерує та обробляє повідомлення. Повідомлення мають
оброблятись у порядку їх надходження. Обробка повідомлення – це просто
показ його на екрані. Використати чергу.
 */
public class A09_01 {

	public static void main(String[] args) {
		long T1 = 1000;
		long T2 = 2000;
		int n = 10;
		ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(n + 1);
		
		Thread putThread = new Thread(() -> put(T1, n, queue));
		Thread getThread = new Thread(() -> get(T2, queue));
		
		Log.print("Start");
		putThread.start();
		getThread.start();
		
		try {
			putThread.join();
			getThread.join();
		} catch (InterruptedException e) {}
		
		Log.print("End");
	}
	
	public static void put(long processTime, int count, ArrayBlockingQueue<String> queue) {
		Thread.currentThread().setName("Put");
		try {
			for (int i = 0; i < count; i++) {
				String msg = "MESSAGE " + i;
				Log.print(msg + " is creating");
				Thread.sleep(processTime);
				Log.print(msg + " is created");
				queue.put(msg);
			}
			queue.put("");
		} 
		catch (InterruptedException e) {}
	}
	
	public static void get(long processTime, ArrayBlockingQueue<String> queue) {
		Thread.currentThread().setName("Get");
		while (true) {
			try {
				String msg = queue.take();
				if (msg.equals(""))
					break;
				Log.print(msg + " extracted from queue");
				Thread.sleep(processTime);
				Log.print(msg + " has been processed");
				System.out.println(">>> " + msg);
			} 
			catch (InterruptedException e) {}
		}
	}
}
