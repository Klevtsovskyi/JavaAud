import java.util.Scanner;


public class T01_06
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int a;
		byte n = in.nextByte();
		for (byte i = 0; i < n; i++)
		{
			a = (int) Math.ceil(Math.random() * 100);
			System.out.println(a);
		}
		for (byte i = 0; i < n; i++)
		{
			a = (int) Math.ceil(Math.random() * 100);
			System.out.print(a + " ");
		}
	}
}
