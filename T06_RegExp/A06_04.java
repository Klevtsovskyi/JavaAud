package T06;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A06_04 {

	public static void main(String[] args) {
		String DATE1 = "\\b\\d{1,2}\\.\\d{1,2}\\.\\d{4}\\b";
		String DATE2 = "\\b\\d{1,2}-\\d{1,2}-\\d{4}\\b";
		String DATE3 = "\\b\\d{4}/\\d{1,2}/\\d{1,2}\\b";
		String DATE = DATE1 + "|" + DATE2 + "|" + DATE3;
		
		String s = "Привіт\r\n"
				+ "Mr. Smith bought ----che-apa@site.com---- for 1.5 million dollars, i.e. he paid a lot for it! 9.12.2020 MY@URK.net\r\n"
				+ "Did he mind? MY.MAIL@MAIL.COM Adam Jones Jr. thinks he didn't. In any case, this isn't true... 03-03-2000, 2019/8/10\r\n"
				+ "Well, with a probability of 0.9 it isn't. \r\n"
				+ "Amount: 231.30. Hello! mail@knu.ua";
		
		Pattern p = Pattern.compile(DATE);
		Matcher m = p.matcher(s);
		
		System.out.println(m.replaceAll(x -> replaceDates(x)));
	}
	
	public static String replaceDates(MatchResult m) {
		String date = m.group();
		String[] arr;
		String day, month, year;
		if (date.contains(".")) {
			arr = date.split("\\.");
			day = arr[0];
			month = arr[1];
			year = arr[2];
		}
		else if (date.contains("-")) {
			arr = date.split("-");
			day = arr[1];
			month = arr[0];
			year = arr[2];
		}
		else {
			arr = date.split("/");
			day = arr[2];
			month = arr[1];
			year = arr[0];
		}
		if (day.length() < 2) day = "0" + day;
		if (month.length() < 2) month = "0" + month;
		
		date = String.join(".", new String[] {day, month, year});
		return date;
	}

}
