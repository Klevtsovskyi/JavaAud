

import java.util.regex.*;


public class T10 
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

		String regex = "\\d+\\.?\\d*";
		printLines(s, regex);
	}
	
	public static void printLines(String s, String regex)
	{
		String rgx = "^(?<sen>.*?(?<reg>" + regex + ").*?)$";
		Pattern p = Pattern.compile(rgx, Pattern.MULTILINE);
		Matcher m = p.matcher(s);
		
		while (m.find())
		{
			System.out.println(m.group("sen"));
			System.out.println(m.group("reg"));
		}
	}

}
