import java.util.Scanner;


public class T05_05 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n, array[];
		n = in.nextInt();
		array = new int[n];
		for (int i = 0; i < array.length; i++)
			array[i] = in.nextInt();
		
		System.out.println(minDigits(array));
	}
	
	public static int minDigits(int[] array)
	{
		int min_num = array[0];
		int min_count = numDigits(min_num);
		
		for (int i = 1; i < array.length; i++)
		{
			int num = array[i];
			int count = numDigits(num);
			
			if (count <= min_count)
			{
				min_num = num;
				min_count = count;
			}
		}
		return min_num;
	}
	
	public static int numDigits(int n)
	{
		int i = 0;
		if (n == 0)
			return 1;
		while (n > 0)
		{
			n /= 10;
			i++;
		}
		return i;
	}
}