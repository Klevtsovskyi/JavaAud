import java.util.regex.*;


public class T06_04 {

	public static void main(String[] args) {
		String s = "Some text.\r\n"
				+ "Date 1: 2020/10/21\r\n"
				+ "Date 2: 10-22-2020\r\n"
				+ "Date 3: 23.10.2020\r\n"
				+ "Another dates: 1.1.1989. :1998/8/8: a7/7/7! 06-05-04! ^3-2-1999!\r\n"
				+ "More dates: 2.10.1999, 09-3-1988, 09.2.2003, 2008/11/11.";
		
		String DATE1 = "\\b\\d{1,2}\\.\\d{1,2}\\.\\d{4}\\b";
		String DATE2 = "\\b\\d{1,2}\\-\\d{1,2}\\-\\d{4}\\b";
		String DATE3 = "\\b\\d{4}\\/\\d{1,2}\\/\\d{1,2}\\b";
		String rgx = DATE1 + "|" + DATE2 + "|" + DATE3;
	
		Pattern p = Pattern.compile(rgx);
		Matcher m = p.matcher(s);
		String res = m.replaceAll(x -> changeDates((Matcher) x));
		System.out.println(res);
	}
	
	public static String changeDates(Matcher m) {
		String date = m.group();
		String arr[];
		
		if (date.contains("."))
			arr = date.split("\\.");
		else if (date.contains("-")) {
			arr = date.split("\\-");
			String temp = arr[0];
			arr[0] = arr[1];
			arr[1] = temp;
		}
		else {
			arr = date.split("\\/");
			String temp = arr[0];
			arr[0] = arr[2];
			arr[2] = temp;
		}
		
		if (arr[0].length() < 2)
			arr[0] = "0" + arr[0];
		if (arr[1].length() < 2)
			arr[1] = "0" + arr[1];
		
		return String.join(".", arr);
	}

}
