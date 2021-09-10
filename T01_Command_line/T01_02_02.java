import java.util.Scanner;


public class T01_02_02 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a, b;
		a = in.nextInt();
		b = in.nextInt();
		String s;
		s = Integer.toString(a);
		System.out.println(s.length());
		s = Integer.toString(b);
		System.out.println(s.length());
		
		int n = (int) (Math.floor(Math.log10(a)) + 1);
		System.out.println(n);
		n = (int) (Math.floor(Math.log10(b)) + 1);
		System.out.println(n);
		
		double h = 2 / (1.0 / a + 1.0 / b);
		System.out.printf("%.2f", h);
		in.close();
	}

}
