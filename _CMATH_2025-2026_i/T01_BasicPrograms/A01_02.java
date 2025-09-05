package T01_BasicPrograms;

public class A01_02 {

	public static void main(String[] args) {
		System.out.println("Hello, World!");

		/* 1.2. Надрукувати всі аргументи з 
		командного рядка. Запустити цю 
		програму через командний рядок.
		*/
		for (int i = 0; i < args.length; i++) {
			System.out.print(args[i] + " ");
		}
	}
}

