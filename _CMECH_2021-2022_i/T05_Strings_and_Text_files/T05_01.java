

public class T05_01 {

	public static void main(String[] args) {
		String s = "     The +9+0String 1ph -bclass2 represents3 bbbbbbcharacter "
				+ "strings.     Allstring literals58 in Java ph"
				+ "phrograms, - such as+ \"abc\", areimplemented "
				+ "as 00instances of this bbclass. pph++2+cbbphhh";
		
		System.out.println(s);
		System.out.println("a >>> " + a(s));
		System.out.println("b >>> " + b(s));
		System.out.println("c >>> " + c(s));
		System.out.println("d >>> " + d(s));
		System.out.println("e >>> " + e(s));
	}

	public static String a(String s) {
		char[] ca = s.toCharArray();
		char[] res = new char[2 * ca.length];
		int j = 0;
		for (int i = 0; i < ca.length; i++) {
			if ('0' <= ca[i] && ca[i] < '9')
				continue;
			else if (ca[i] == '+' || ca[i] == '-')
				res[j++] = ca[i];
			res[j++] = ca[i];
		}
		return new String(res);
	}
	
	public static String b(String s) {
		StringBuilder sb = new StringBuilder(s);
		int i = 0;
		while (true) {
			i = sb.indexOf("+", i);
			if (i == -1 || i + 1 >= sb.length())
				break;
			char c = sb.charAt(i + 1);
			if (Character.isDigit(c)) {
				sb.deleteCharAt(i);
				if (i > 0)
					i--;
			}
			else
				i++;
		}
		return sb.toString();
	}
	
	public static String c(String s) {
		StringBuffer sb = new StringBuffer(s);
		int i = 0;
		while (true) {
			i = sb.indexOf("bc", i);
			if (i == -1)
				break;
			int j = i;
			while (j > 0 && sb.charAt(j - 1) == 'b')
				j--;
			sb.delete(j, i + 1);
		}
		return sb.toString();
	}
	
	public static String d(String s) {
		return s.replaceAll("ph", "f");
	}
	
	public static String e(String s) {
		String[] ss = s.trim().split("\\s+");
		return String.join(" ", ss);
	}
}
