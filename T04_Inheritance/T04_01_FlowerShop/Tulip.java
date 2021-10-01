package T04_01_FlowerShop;


public class Tulip extends Flower {

	public Tulip(double length, double freshness) {
		super(length, freshness);
	}
	
	public String toString() {
		return "Тюльпан. " + super.toString();
	}

	@Override
	public double getPrice() {
		return length * 7 * (freshness < 1 ? 1 : 1 / freshness);
	}
}
