package T01_BasicPrograms;

public class A01_03 {
	
	/*
	 * Підрахувати суму аргументів командного рядка. 
	 * Якщо аргументи не є дійсними числами, 
	 * вивести про це повідомлення.
	 */
	public static void main(String[] args) {
		double s = 0;
		for (int i = 0; i < args.length; i++) {
			try {
				s += Double.parseDouble(args[i]);
			}
			catch (NumberFormatException e) {
				System.out.println("Аргументи не є дійсними числами");
				System.exit(0);
			}
		}
		System.out.println(s);
	}

}
