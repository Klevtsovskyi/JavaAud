package T05_01;


public abstract class Flower implements Comparable<Flower>
{
	protected double length;
	protected double freshness;
	
	Flower(double length, double freshness)
	{
		this.length = length;
		this.freshness = freshness;
	}
	
	public double getLength() {return length;}
	public double getFreshness() {return freshness;}
	abstract public double getPrice();
	
	public String toString()
	{
		return ("Квітка." + 
				"Довжина стебля:" + length + ". " +
				"Свіжість: " + freshness + ". " +
				"Ціна: " + getPrice() + ".\n");
	}
	
	public int compareTo(Flower f)
	{
		if (getFreshness() > f.getFreshness())
			return 1;
		else if (getFreshness() == f.getFreshness())
			return 0;
		else
			return -1;
	}
}
