

// import java.util.Scanner;
// import java.util.Arrays;
import java.util.StringTokenizer;


public class T01 
{

	public static void main(String[] args) 
	{
		// Scanner in = new Scanner(System.in);
		// String s = in.nextLine();
		String s = ("    -He1+1o!- *phph bc cb ++100 "
				+ "Hello!+    *  "
				+ "  *  100 +1 pfp   *   hhhhh"
				+ "b*b*bb*c cbc    *bbcc *bbphfpf b     ");
		System.out.println(s);
		
		System.out.println(f1(s));
		System.out.println(f2(s));
		System.out.println(f3(s));
		System.out.println(f4(s));
		System.out.println(f5(s));
		
		// in.close()
	}
	
	public static String f1(String s)
	{
		char ca[] = s.toCharArray();
		char rez[] = new char[2*ca.length];
		int j = 0;
		for (int i = 0; i < ca.length; i++)
		{
			//if ('0' <= ca[i] && ca[i] <= '9')
			if (Character.isDigit(ca[i]))
				continue;
			else if (ca[i] == '+' || ca[i] == '-')
				rez[j++] = ca[i];
			rez[j++] = ca[i];
		}
		return new String(rez);
	}

	public static String f2(String s)
	{
		StringBuffer sb = new StringBuffer(s);
		int i = 0;
		while (true)
		{
			i = sb.indexOf("+", i);
			if (i == -1 || i + 1 >= sb.length())
				break;
			char c = sb.charAt(i + 1);
			if (Character.isDigit(c))
				sb.deleteCharAt(i);
			i++;
		}
		return sb.toString();
	}
	
	public static String f3(String s)
	{
		StringBuilder sb = new StringBuilder(s);
		int i = 0, offset;
		while (true)
		{
			i = sb.indexOf("b", i);
			if (i == -1 || i + 1 >= sb.length())
				break;
			
			offset = 1;
			while (true)
			{
				if (i + offset >= sb.length())
				{
					i += offset;
					break;
				}
				char c = sb.charAt(i + offset);
				if (c == 'b')
					offset++;
				else if (c == 'c')
				{
					sb.delete(i, i + offset);
					break;
				}
				else
				{
					i += offset;
					break;
				}
			}
			i++;
		}
		return sb.toString();
	}

	public static String f4(String s)
	{
		return s.replace("ph", "f");
	}
	
	public static String f5(String s)
	{
		// String[] ss = s.split(" ");
		// System.out.println(Arrays.toString(ss));
		// s = String.join(" ", ss);
		StringTokenizer st = new StringTokenizer(s, " ");
		StringBuilder sb = new StringBuilder();
		while (st.hasMoreTokens())
		{
			sb.append(st.nextToken() + "~");
		}
		return sb.toString();
	}
}
