import java.util.Scanner;


public class T02_01 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n, m, k, res;
		n = in.nextInt();
		m = in.nextInt();
		// n = 5: 101
		// m = 1
		// res = 7: 111
		System.out.println(Integer.toBinaryString(n));
		k = 1 << m;
		// System.out.println(Integer.toBinaryString(k));
		res = n ^ k; // 101 ^ 010 = 111
		System.out.println(Integer.toBinaryString(res));
		System.out.println(res);
	}	
}
