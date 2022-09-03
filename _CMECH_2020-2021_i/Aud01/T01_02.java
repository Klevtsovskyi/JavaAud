import java.util.Scanner;


public class T01_02
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int a, b;
		float h;
		a = in.nextInt();
		b = in.nextInt();
		System.out.println("Кількість розрядів числа " + a + 
				": " + Math.round(Math.ceil(Math.log10(a + 1))));
		String s = Integer.toString(b);
		System.out.printf("Кількість розрядів числа %d: %d\n", b, s.length());
		h = 1 / ((float) 1 / a + (float) 1 / b);
		System.out.printf("Середнє гармонічне: %.2f\n", h);
	}
}
