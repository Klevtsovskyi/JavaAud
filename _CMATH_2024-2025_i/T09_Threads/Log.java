package T09_Threads;

public class Log {
	
	static private long start = System.currentTimeMillis();
	
	static public void print(String msg) {
		System.out.printf(
			"[%6.3f] %s: %s\n",
			(System.currentTimeMillis() - start) / 1000.0,
			Thread.currentThread().getName(),
			msg
		);
	}
}
