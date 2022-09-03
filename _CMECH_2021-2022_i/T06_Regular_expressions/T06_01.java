
public class T06_01 {

	public static void main(String[] args) {
		String s = "         Mr.         Smith   bought cheapsite.com for 1.5 million dollars, i.e. he paid a lot for it!\r\n"
				+ "Did he          mind?      \r\n"
				+ "Adam Jones         Jr. thinks he didn't.    \r\n"
				+ "In any case,           this isn't true...\r\n"
				+ "        Well,       with a         probability of 0.9 it isn't. \r\n"
				+ "Amount:     231.30.\r\n"
				+ "     Hello!";
		
		System.out.println(longestWord(s));
		System.out.println(removeSpaces(s));
	}
	
	public static String longestWord(String s) {
		String ss[] = s.trim().split("[\\s\\.,\\!\\?;:]+");
		String _longestWord = "";
		for (String word: ss) {
			if (word.length() > _longestWord.length())
				_longestWord = word;
		}
		return _longestWord;
	}
	
	public static String removeSpaces(String s) {
		String ss[] = s.trim().split("\\s+");
		return String.join(" ", ss);
	}

}
