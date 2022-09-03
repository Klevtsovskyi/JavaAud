package T08_01;

public class Main {

	public static void main(String[] args) {
		GeneralStaff generalStaff = 
			new GeneralStaff("GS1", 100, 10);
		MilitaryBase militaryBase =
			new MilitaryBase("MB1", 1000, 200);
		
		System.out.println(generalStaff);
		System.out.println(militaryBase);
		System.out.println();
		
		SecretAgent secretAgent = new SecretAgent();
		generalStaff.accept(secretAgent);
		System.out.println(secretAgent);
		militaryBase.accept(secretAgent);
		System.out.println(secretAgent);
		System.out.println();
		
		Saboteur saboteur = new Saboteur();
		generalStaff.accept(saboteur);
		System.out.println(saboteur);
		militaryBase.accept(saboteur);
		System.out.println(saboteur);

	}

}
