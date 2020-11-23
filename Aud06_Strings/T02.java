
public class T02 
{

	public static void main(String[] args) 
	{
		String s = "ABC, , C321, ASF,,";
		
		System.out.println(s.indexOf(','));
		System.out.println(s.lastIndexOf(','));
		System.out.println(countOf(s, ','));
	}
	
	public static int countOf(String s, char c)
	{
		int i = 0, count = 0;
		while (true)
		{
			i = s.indexOf(c, i);  // s.indexOf(substring, i)
			if (i == -1)
				break;
			count++;
			i++;  // i += substring.length()
		}
		return count;
	}
}
