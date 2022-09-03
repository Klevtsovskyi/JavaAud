package T05_01;


public class Rose extends Flower 
{
	Rose(double length, double freshness)
	{
		super(length, freshness);
	}
	
	public String toString()
	{
		return "Роза. " + super.toString();
	}
	
	public double getPrice()
	{
		return length * 10 * (freshness < 1 ? 1 : 1/freshness);
	}
}
