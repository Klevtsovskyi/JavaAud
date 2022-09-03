import java.util.Locale;
import java.util.Scanner;

public class T02_02_04 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.Category.FORMAT, new Locale("en", "US"));
//		System.out.println(Locale.getDefault());
		Scanner in = new Scanner(System.in);
//		double d = in.nextDouble();
//		System.out.println(d);
		
		int n, m;
		n = in.nextInt();
		m = in.nextInt();
		// n = 5     101
		// m = 1
		System.out.println(Integer.toBinaryString(n));
		int k = 1 << m;  // 010
		n = n ^ k;  // 111
		System.out.println(n);
		System.out.println(Integer.toBinaryString(n));
		in.close();
	}

}
