import java.util.Scanner;
// 1.3
// javac -encoding utf8 Hello.java
// java Hello Abc 1.1 6.7
// 1.8
// javadoc -docencoding cp1251 -charset cp1251 -author -version Hello.java

/** Програма Hello
 * @author Arsen Klevtsovskyi
 * @version 1.0
 */
public class Hello {

	/** Головна функція
	 * @param args - аргументи командноо рядка
	 */
	public static void main(String[] args) {
		// 1.2
		System.out.println("Hello, World!");
		// 1.7
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();
		System.out.printf("Привіт, %s!\n", name);
		double s = 0;
		// 1.5
		// 1.6
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
			try {
				double x = Double.parseDouble(args[i]);
				s += x;
			}
			catch (Exception e) {}
		}
		System.out.println(s);

		in.close();

	}
}
