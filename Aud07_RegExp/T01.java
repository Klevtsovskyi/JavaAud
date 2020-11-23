

import java.util.regex.*;


public class T01 
{
	public static void main(String[] args) 
	{
		String s = "  Mr. Smith bought  cheapsite.com    " +
		" for   1.5\n                   " +
		"million dollars, i.e. he paid a lot for it!\n" +
		"Did he mind? Adam Jones Jr. thinks he didn't.\n " +
		"In any case, this isn't true...\n" +
		"Well, with a probability of 0.9 it isn't. \n" +
		"Amount: 231.30.\n" +
		"Hello!         ";
		System.out.println(s + "\n");
		
		System.out.println(f1LongestWord1(s));
		System.out.println(f1LongestWord2(s));
		System.out.println(f2CountOfWords(s));
		System.out.println(f3RemoveSpaces(s, 1));
		System.out.println(f4RemoveSpaces(s));
		System.out.println(f5(s));

	}
	
	public static String f1LongestWord1(String s)
	{
		s = s.trim();
		//String[] ss = s.split("\\s+");
		String[] ss = s.split("[\\s\\.,\\!\\?;:]+");
		
		String longestWord = "";
		for (int i = 0; i < ss.length; i++)
		{
			// System.out.println(ss[i]);
			if (ss[i].length() > longestWord.length())
				longestWord = ss[i];
		}
		return longestWord;
	}
	
	public static String f1LongestWord2(String s)
	{
		Pattern p = Pattern.compile("\\b((?:[\\w\\-\\']+\\.?)+)(?<![\\w\\'\\.]{3}\\.)(?:\\s|\\b)");
		Matcher m = p.matcher(s);
		String longestWord = "";
		while (m.find())
		{
			//System.out.println(m.group(1));
			if (m.group(1).length() > longestWord.length())
				longestWord = m.group(1);
		}
		return longestWord;
	}
	
	public static int f2CountOfWords(String s)
	{
		Pattern p = Pattern.compile("\\b((?:[\\w\\-\\']+\\.?)+)(?<![\\w\\'\\.]{3}\\.)(?:\\s|\\b)");
		Matcher m = p.matcher(s);
		int count = 0;
		while (m.find())
			count++;
		return count;
	}
	
	public static String f3RemoveSpaces(String s, int n)
	{
		String[] ss = s.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ss.length; i++)
		{
			if (ss[i].length() > n)
				sb.append(ss[i] + " ");
		}
		return sb.toString();
	}
	
	public static String f4RemoveSpaces(String s)
	{
		return f3RemoveSpaces(s, 0);
	}
	
	public static String f5(String s)
	{
		Pattern p = Pattern.compile("\\s+");
		StringBuilder sb = new StringBuilder();
		String[] ss;
		int i = 0, j = 0;
		while (j < s.length())
		{
			j = s.indexOf('\n', j);
			if (j == -1)
				j = s.length() - 1;
			ss = p.split(s.substring(i, j).trim());
			if (ss.length == 1)
			{
				sb.append(ss[0]);
				break;
			}
			
			int width = 0;
			for (int k = 0; k < ss.length; k++)
				width += ss[k].length();
			
			int spaces = 80 - width;
			int average = spaces / (ss.length - 1);
			int remain = spaces - average * (ss.length - 1);
			
			for (int k = 0; k < ss.length; k++)
			{
				sb.append(ss[k]);
				for (int kk = 0; kk < average; kk++)
				{
					sb.append(" ");
				}
				if (remain > 0)
				{
					sb.append(" ");
					remain--;
				}
			}
			sb.append("\n");
			i = ++j;
		}
		return sb.toString();
	}
}
