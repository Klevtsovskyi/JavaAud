package T01_BasicPrograms;

import java.util.Locale;
import java.util.Scanner;

/*
 * Ввести (через консоль) два цілих числа та вивести кількість їх розрядів 
 * (розв’яжіть це за допомогою рядків та використовуючи логарифм). 
 * Обчисліть середнє гармонічне та виведіть його з точністю до двох знаків після коми.
 */
public class A01_05 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		
		System.out.println(a + ": " + (int) Math.ceil(Math.log10(a)));
		System.out.println(b + ": " + Integer.toString(b).length());
		
		double h = 2.0 / (1.0 / a + 1.0 / b);
		System.out.printf("Result: %.2f", h);
		in.close();
	}

}