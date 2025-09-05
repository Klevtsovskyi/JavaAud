package T01_BasicPrograms;

import java.util.Locale;
import java.util.Scanner;

public class A01_04 {
	
	/*
	 * Ввести (через консоль) дійсне число. Вивести в окремих рядках його цілу та 
	 * дробову частини.
	 * Примітка. Для того, щоб записувати дійсні числа через крапку, необхідно 
	 * виконати таку команду:
	 * Locale.setDefault(Locale.US);
	 */
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		Scanner in = new Scanner(System.in);
		
		double d = in.nextDouble();
		int a = (int) d;
		double b = d - a;
		System.out.printf("%d %f", a, b);
		
		in.close();
	}

}
