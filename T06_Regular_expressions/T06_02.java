import java.util.regex.*;


public class T06_02 {

	public static void main(String[] args) {
		String s = "Mr. Smith   bought cheapsite.com for 1.5 million dollars, i.e. he paid a lot for it!\r\n"
				+ "Did he mind? \r\n"
				+ "Adam Jones Jr. thinks he didn't. \r\n"
				+ "In any case, this isn't true...\r\n"
				+ "Well, with a probability of 0.9 it isn't. \r\n"
				+ "Amount: 231.30.\r\n"
				+ "Hello!";
		
		String subrgx = "\\d";
		String rgx = "^(?<str>.*?(?<rgx>" + subrgx + ").*)$";
		
		Pattern p = Pattern.compile(rgx, Pattern.MULTILINE);
		Matcher m = p.matcher(s);
		
		while (m.find()) {
			System.out.println(m.group("str"));
			System.out.println(m.group("rgx"));
		}
		
	}
	
}
