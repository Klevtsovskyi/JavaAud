package T05_Strings;

public class A05_01 {

    public static void main(String[] args) {
        String s = "+++++05.01.    Які класи    t ph при роботі з рядками в Java?\n" +
                "05.++02.\t\t\t\t\t В чому     phрізниця між класами StringBuphper та te+-1?\n" +
                "05.0+3. Яким чином можна відкрити2+4  ++ ++ читання/запису?\n" +
                "05.04. Для чого +0\t\t обгортки BufferedphReader і Scanner та\n" +
                "BuphpheredWriter і    PrintWriter? Які між ними відмінності?\n" +
                "05.05. Яким чином відкрити     5ночасно для читання та запису?+";

//        System.out.println(a(s));
//        System.out.println(b(s));
//        System.out.println(c(s));
        System.out.println(d(s));

    }

    /* подвоївши всі цифри */
    public static String a(String s) {
        char[] chars = s.toCharArray();
        char[] result = new char[chars.length * 2];

        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                result[j++] = chars[i];
            }
            result[j++] = chars[i];
        }
        return String.copyValueOf(result, 0, j);
    }

    /* виключивши з нього всі знаки '+', безпосередньо за якими знаходиться цифра */
    public static String b(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while (true) {
            i = sb.indexOf("+", i);
            if (i == -1 || i + 1 >= sb.length()) {
                break;
            }
            char c =  sb.charAt(i + 1);
            if (Character.isDigit(c)) {
                sb.deleteCharAt(i);
                if (i > 0)
                    i--;
            }
            else {
                i++;
            }
        }
        return sb.toString();
    }

    /* замінивши в ньому всі пари 'ph' на літеру 'f' */
    public static String c(String s) {
        return s.replaceAll("ph", "f");
    }

    /* виключивши з нього всі зайві пропуски, тобто з кількох, що йдуть підряд, залишити один */
    public static String d(String s) {
        return s.replaceAll("\\s+", " ");
    }
}
