import java.util.regex.*;


public class T06_03 {

	public static void main(String[] args) {
		String s = "Mr. Smith bought cheapsite.com for 1.5 million dollars, i.e. he paid a lot for it! Did he mind? Adam Jones Jr. thinks he didn't. In any case, this isn't true... Well, with a probability of 0.9 it isn't. Amount: 231.30. Hello!";
		String rgx = "\\b[A-Z].*?[\\.\\!\\?](?<![A-Z\\.][a-z]\\.)(?=\\s|$)";
		
		Pattern p = Pattern.compile(rgx);
		Matcher m = p.matcher(s);
		
		while (m.find()) {
			System.out.println(m.group());
		}
	}

}
