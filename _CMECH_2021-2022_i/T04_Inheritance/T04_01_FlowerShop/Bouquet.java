package T04_01_FlowerShop;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public final class Bouquet {
	
	public Flower[] flowers;

	public Bouquet(Flower[] flowers) {
		this.flowers = flowers;
	}
	
	public String toString() {
		return Arrays.toString(flowers);
	}
	
	public double getPrice() {
		double sum = 0;
		for (Flower flower: flowers)
			sum += flower.getPrice();
		return sum;
	}
	
	public void sort() {
		Arrays.sort(flowers);
	}
	
	public Bouquet findByLength(double min, double max) {
		List<Flower> list = new ArrayList<Flower>();
		for (int i = 0; i < flowers.length; i++) {
			if (min <= flowers[i].length &&
				flowers[i].length < max)
				list.add(flowers[i]);
		}
		return new Bouquet(list.toArray(new Flower[0]));
	}
}
