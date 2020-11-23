import java.util.Scanner;


public class T05_01 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n, array[], min, max;
		n = in.nextInt();
		array = new int[n];
		for (int i = 0; i < array.length; i++)
			array[i] = in.nextInt();
		
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		System.out.println(min);
		System.out.println(max);
		for (int x: array)
		{
			if (x < min)
				min = x;
			if (x > max)
				max = x;
		}
		System.out.println("\nMIN: " + min);
		System.out.println("\nMAX: " + max);
	}
}

