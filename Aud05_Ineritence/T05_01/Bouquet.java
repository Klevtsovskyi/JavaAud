package T05_01;


import java.util.Arrays;


public class Bouquet 
{
	private Flower[] flowers;
	
	Bouquet(Flower[] flowers)
	{
		this.flowers = flowers;
	}
	
	public double price()
	{
		double s = 0;
		for (Flower flower: flowers)
			s += flower.getPrice();
		return s;
	}
	
	public int find(double minl, double maxl)
	{
		for (int i =0; i < flowers.length; i++)
		{
			if (minl < flowers[i].getLength() &&
				flowers[i].getLength() < maxl)
				return i;
		}
		return -1;
	}
	
	public String toString()
	{
		return Arrays.toString(flowers);
	}
	
	public void sort()
	{
		Arrays.sort(flowers);
	}
}
