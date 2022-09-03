

import java.util.Scanner;


public class T02_01_Fraction
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Fraction[] array = new Fraction[n];
		for (int i = 0; i < n; i++)
			array[i] = new Fraction(in.nextInt(), in.nextInt());
		
		print(array);
		change(array);
		print(array);
	}
	
	public static void print(Fraction[] array)
	{
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}
	
	public static void change(Fraction[] array)
	{
		for (int i = 1; i < array.length; i++)
			array[i] = array[i].add(array[i-1]);
	}
}

class Fraction
{
	private int m;
	private int n;
	
	Fraction(int m, int n)
	{
		int k = Math.abs(gcd(m, n));
		this.m = m / k;
		this.n = n / k;
	}
	
	public String toString()
	{
		return this.m + "/" + this.n;
	}
	
	public Fraction add(Fraction x)
	{
		int m = this.m * x.n + this.n * x.m;
		int n = this.n * x.n;
		int k = Math.abs(gcd(m, n));
		return new Fraction(m / k, n / k);
	}
	
	public static int gcd(int a, int b)
	{
		if (b == 0) return a;
		return gcd(b, a % b);
	}
}