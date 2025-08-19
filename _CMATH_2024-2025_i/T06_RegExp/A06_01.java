package T06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A06_01 {

	public static void main(String[] args) {
		String s = "abc1234z512xyz\r\n"
				+ "Привіт -my-MAIL@gmail.com   my.mail123@gmail.com.\r\n"
				+ "Mr. Smith bought cheapsite.com for 1.5 million dollars, i.e. he paid a lot for it! \r\n"
				+ "Did he mind? Adam Jones Jr. thinks he didn't. In any case, this isn't true...  mail@knu.ua\r\n"
				+ "Well, with a probability of 0.9 it isn't. Amount: 231.30. Hello!\r\n"
				+ "mail@mnauil";
		
		String PATTERN = "\\b[\\w\\-\\.]+@[\\w\\-\\.]+\\b";
		
		Pattern pattern = Pattern.compile(PATTERN);
		Matcher matcher = pattern.matcher(s);
		
		while(matcher.find())
			System.out.println(matcher.group());
	}

}
