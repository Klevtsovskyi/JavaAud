import java.util.Scanner;


public class T04_05 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n;
		float x;
		n = in.nextInt();
		x = in.nextFloat();
		System.out.println(cheb(x, n));
	}
	
	public static float cheb(float x, int n)
	{
		float t0, t1, t2;
		t0 = 1;
		t1 = x;
		for (int i = 0; i < n; i++)
		{
			t2 = 2 * x * t1 - t0;
			t0 = t1;
			t1 = t2;
		}
		return t0;
	}
}

