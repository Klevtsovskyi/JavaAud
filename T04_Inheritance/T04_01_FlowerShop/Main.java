package T04_01_FlowerShop;


public class Main {

	public static void main(String[] args) {
		Flower flowers[] = {
			new Rose(10, 1),
			new Tulip(9, 1.3),
			new Tulip(8, 0.8),
			new Rose(11, 1.2),
			new Rose(7, 0.7)
		};
		Bouquet b = new Bouquet(flowers);
		
		System.out.println(b);
		System.out.println(b.getPrice());
		
		b.sort();
		System.out.println(b);
		
		System.out.println(b.findByLength(8, 10));
	}
}
