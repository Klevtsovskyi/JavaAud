package T04_01_FlowerShop;


public class Rose extends Flower {

	public Rose(double length, double freshness) {
		super(length, freshness);
	}
	
	public String toString() {
		return "Роза. " + super.toString();
	}

	@Override
	public double getPrice() {
		return length * 10 * (freshness < 1 ? 1 : 1 / freshness);
	}
}
