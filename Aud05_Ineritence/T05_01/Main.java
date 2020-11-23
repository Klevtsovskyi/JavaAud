package T05_01;

public class Main 
{
	public static void main(String[] args)
	{
		Flower[] flowers = new Flower[5];
		
		flowers[0] = new Rose(10, 1);
		flowers[1] = new Tulip(11, 1.5);
		flowers[2] = new Tulip(12, 3);
		flowers[3] = new Rose(9, 1.1);
		flowers[4] = new Tulip(9, 0.1);
		
		Bouquet b = new Bouquet(flowers);
		System.out.println(b);
		System.out.println(b.price());
		
		int i = b.find(8, 10);
		if (i != -1)
			System.out.println(flowers[i]);
		
		b.sort();
		System.out.println(b);
	}
}
