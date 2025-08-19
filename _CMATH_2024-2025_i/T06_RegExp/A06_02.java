package T06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A06_02 {

	public static void main(String[] args) {
		String s = "Знайти в тексті всі рядки, фрагментом яких є заданий регулярний вираз..\r\n"
				+ "Привіт\r\n"
				+ "Mr. Smith bought ----che-apa@site.com---- for 1.5 million dollars, i.e. he paid a lot for it! 9.12.2020 MY@URK.net\r\n"
				+ "Did he mind? MY.MAIL@MAIL.COM Adam Jones Jr. thinks he didn't. In any case, this isn't true... 03-03-2000, 2019/8/10\r\n"
				+ "Well, with a probability of 0.9 it isn't. \r\n"
				+ "Amount: 231.30. Hello! mail@knu.ua";
		
		String subrgx = "\\d";
		String rgx = "^(?<rgx>.*?(?<subrgx>" + subrgx + ").*)$";
		
		Pattern p = Pattern.compile(rgx, Pattern.MULTILINE);
		Matcher m = p.matcher(s);
		
		while (m.find())
			System.out.println(m.group("subrgx") + " -> " + m.group("rgx"));
	}

}
