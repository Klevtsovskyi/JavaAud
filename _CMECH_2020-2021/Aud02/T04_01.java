import java.util.Scanner;


public class T04_01 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n;
		n = in.nextInt();
		if (n <= 0)
			System.out.println("Число не натуральне!");
		else
		{
			System.out.println(fact1(n));
			System.out.println(fact2(n));
		}
	}
	
	public static long fact1(int n)
	{
		long s = 1;
		for (int i = 1; i < n + 1; i++)
			s *= i;
		return s;
	}
	
	public static long fact2(int n)
	{
		if (n == 0)
			return 1;
		else
			return n * fact2(n-1);
	}
}
