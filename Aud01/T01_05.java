import java.util.Scanner;


public class T01_05
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		for (int i = args.length - 1; i > -1; i--)
			System.out.println(args[i]);
	}
}
