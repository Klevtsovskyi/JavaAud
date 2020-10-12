package T05_01;


public class Tulip extends Flower 
{
	Tulip(double length, double freshness)
	{
		super(length, freshness);
	}
	
	public String toString()
	{
		return "Тюльпан. " + super.toString();
	}
	
	public double getPrice()
	{
		return length * 7 * (freshness < 1 ? 1 : 1/freshness);
	}
}
