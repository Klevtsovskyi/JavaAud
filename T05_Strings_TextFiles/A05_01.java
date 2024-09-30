package T05_Strings_TextFiles;

public class A05_01 {

	public static void main(String[] args) {
		String s = (
			"+++2. Бітові операції. Умови. Цикли.			\n"
			+ "+3. ООП.		phphphp	3. ООП.		ph	++4. Наслідування.			\n\r"
			+ "5. Рядки та текстові файли.			6. phphегулярні вирази.			\n"
			+ "++++++++7. Бінарні файли та серіалізація.		\n"
		);
		System.out.println("a)\n" + a(s));
		System.out.println("b)\n" + b(s));
		System.out.println("c)\n" + c(s));
		System.out.println("d)\n" + d(s));

	}
	/* a) подвоївши всі цифри; */
	public static String a(String s) {
		char[] array = new char[s.length() * 2];
		int j = 0;
		for (int i = 0; i < s.length(); i++) {
//			if ('0' <= s.charAt(i) && s.charAt(i) <= '9')
			if (Character.isDigit(s.charAt(i))) 
				array[j++] = s.charAt(i);
			array[j++] = s.charAt(i);
		}
		return String.copyValueOf(array, 0, j);
	}
	/* b) виключивши з нього всі знаки '+', безпосередньо за якими знаходиться цифра; */
	public static String b(String s) {
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < sb.length(); i++) {
			if (
				sb.charAt(i) == '+' &&
				i + 1 < sb.length() &&
				Character.isDigit(sb.charAt(i + 1))
			)
				sb.deleteCharAt(i--);
		}
		return sb.toString();
	}
	
	/* c) замінивши в ньому всі пари 'ph' на літеру 'f'; */
	public static String c(String s) {
		return s.replaceAll("ph", "f");
	}
	
	/* d) виключивши з нього всі зайві пропуски, тобто з кількох, що йдуть підряд, залишити один. */
	public static String d(String s) {
		return String.join(" ", s.split("\\s+"));
	}
}
