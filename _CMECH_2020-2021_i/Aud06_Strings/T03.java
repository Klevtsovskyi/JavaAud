
public class T03 
{

	public static void main(String[] args) 
	{
		String s = "String(String) (abc) ABC(1);";
		
		System.out.println(s);
		// System.out.println(checkBrackets(s));
		if (checkBrackets(s))
			System.out.println(removeBrackets(s));
	}
	
	public static boolean checkBrackets(String s)
	{
		boolean closed = true;
		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) == '(')
			{
				if (closed)
					closed = false;
				else
					return false;
			}
			else if (s.charAt(i) == ')')
			{
				if (!closed)
					closed = true;
				else
					return false;
			}
		}
		return closed;
	}
	
	public static String removeBrackets(String s)
	{
		StringBuilder sb = new StringBuilder(s);
		int i = 0, j = 0;
		while (true)
		{
			i = sb.indexOf("(", i);
			if (i == -1)
				break;
			j = sb.indexOf(")", i);
			sb.delete(i, j + 1);
		}
		return sb.toString();
	}

}
