import java.util.Scanner;

public class T02_02_05 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		System.out.println(Integer.toBinaryString(n));
		// 130   10000010
		int k = 1 << 7;  // 10000000
		int m = k & n;
		if (m == 0) {
			n = n << 1;
		}
		else {
			// System.out.println(Integer.toBinaryString(k));
			k = k - 1;  // 01111111
			// System.out.println(Integer.toBinaryString(k));
			n = n & k;   // 00000010
			// System.out.println(Integer.toBinaryString(n));
			n = n << 1;  // 00000100
			// System.out.println(Integer.toBinaryString(n));
			n = n | 1;
		}
		System.out.println(n);
		System.out.println(Integer.toBinaryString(n));
		
		in.close();

	}

}
