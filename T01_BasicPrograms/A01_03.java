package T01_BasicPrograms;

/*
 * Підрахувати суму аргументів командного рядка. 
 * Якщо аргументи не є дійсними числами, вивести про це повідомлення.
 */
public class A01_03 {

	public static void main(String[] args) {
//		char c = 'A'; // 1
//		byte b = 127; // 1
//		short s = 128; // 2
//		int i = 129; // 4
//		long l = 130L; // 8
//		float f = 12.3f; // 4
		double d = 0.0; // 8
//		boolean bb = true;
		
		for (int j = 0; j < args.length; j++) {
			System.out.println(args[j]);
			try {
				d += Double.parseDouble(args[j]);
			} catch (NumberFormatException e) {
				System.err.println("Bad argument!");
			}
			
//			Ctrl + Space
		}
		System.out.printf("%.4f", d);
	}

}
