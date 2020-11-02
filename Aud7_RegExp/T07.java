
public class T07 
{
	public static void main(String[] args) 
	{
		String s = "ABC abc ABC123 12345";
		System.out.println(s);
		s = remove(s, "AB1");
		System.out.println(s);
	}
	
	public static String remove(String s, String chars)
	{
		String rgx = "[" + chars + "]";
		s = s.replaceAll(rgx, "");
		return s;
	}
}
