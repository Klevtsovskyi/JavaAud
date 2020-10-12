

import java.util.Vector;


public class T08_02 
{
	public static void main(String[] args)
	{
		Payment p = new Payment();
		p.append("bill1", 102.5);
		p.append("bill2", 80.0);
		p.print();
		
	}
}

class Payment
{
	class Bill
	{
		private String note;
		private double amount;
		
		Bill(String note, double amount)
		{
			this.note = note;
			this.amount = amount;
		}
		
		public String toString()
		{
			return note + ": " + amount; 
		}
	}
	
	private Vector<Bill> bills = new Vector<Bill>();
	
	public void append(String note, double amount)
	{
		bills.addElement(new Bill(note, amount));
	}
	
	public void print()
	{
		System.out.println(bills.toString());
		double s =0;
		for (int i = 0; i < bills.size(); i++)
			s += bills.get(i).amount;
		System.out.println("Сума: " + s);
	}
	
	public void clear()
	{
		bills.clear();
	}
}