package T12_DesignPatterns;

public class Main {

	public static void main(String[] args) {
		GeneralStaff g = new GeneralStaff("Mackva 1", 30, 100);
		MilitaryBase m = new MilitaryBase("Golybyi shampur", 1000, 125);
		SecretAgent secretAgent = new SecretAgent("Arestovych");
		Saboteur saboteur = new Saboteur("Godron");
		
		System.out.println(g);
		g.accept(secretAgent);
		System.out.println(secretAgent);
		g.accept(saboteur);
		System.out.println(saboteur);
		System.out.println(g);
		
		System.out.println(m);
		m.accept(secretAgent);
		System.out.println(secretAgent);
		m.accept(saboteur);
		System.out.println(saboteur);
		System.out.println(m);
	}
}
