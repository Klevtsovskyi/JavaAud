
public class Log {

	private static long startTime = System.currentTimeMillis();
	
	public static void print(String message) {
		System.out.printf(
			"[%6.3f] %s: %s\n",
			(System.currentTimeMillis() - startTime) / 1000.0,
			Thread.currentThread().getName(),
			message
		);
	}
}
