package T01_BasicPrograms;

import java.util.Locale;
import java.util.Scanner;

/*
 * Ввести (через консоль) дійсне число. 
 * Вивести в окремих рядках його цілу та дробову частини
 */
public class A01_04 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		Scanner in = new Scanner(System.in);
		double x = in.nextDouble();
		System.out.println((int) x);
		System.out.println(x - (int) x);
		in.close();
	}

}
