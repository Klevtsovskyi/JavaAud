

import java.io.*;
import java.util.Vector;
import java.util.Arrays;


public class T01 
{

	public static void main(String[] args) 
	{
		Passenger[] passengers =
			{
					new Passenger(1, "A"),
					new Passenger(2, "B"),
					new Passenger(3, "C")
			};
		Luggage[] luggage = 
			{
				new Luggage(1, "A1", 10),
				new Luggage(1, "A2", 12),
				new Luggage(1, "A3", 8),
				new Luggage(2, "B1", 7),
				new Luggage(3, "C1", 5.4),
				new Luggage(3, "C2", 5.5)
			};
		
		save("input.passengers", passengers);
		save("input.luggage", luggage);
		
		passengers = null;
		luggage = null;
		
		passengers = loadPassengers("input.passengers");
		luggage = loadLuggage("input.luggage");
		
		System.out.println(Arrays.toString(passengers));
		System.out.println(Arrays.toString(luggage));
		
		System.out.print(f1("input.passengers", "input.luggage"));

	}
	
	public static void 
	save(String filename, Passenger[] passengers)
	{
		FileOutputStream fos;
		BufferedOutputStream bos;
		ObjectOutputStream oos;
		
		try
		{
			fos = new FileOutputStream(filename);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			
			for (int i = 0; i < passengers.length; i++)
				oos.writeObject(passengers[i]);
			
			oos.close();
		}
		catch (IOException e) {System.out.println(e);}
	}
	
	public static void 
	save(String filename, Luggage[] luggage)
	{
		FileOutputStream fos;
		BufferedOutputStream bos;
		ObjectOutputStream oos;
		
		try
		{
			fos = new FileOutputStream(filename);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			
			for (int i = 0; i < luggage.length; i++)
				oos.writeObject(luggage[i]);
			
			oos.close();
		}
		catch (IOException e) {System.out.println(e);}
	}
	
	public static Passenger[]
	loadPassengers(String filename)
	{
		FileInputStream fis;
		BufferedInputStream bis;
		ObjectInputStream ois;
		
		try
		{
			fis = new FileInputStream(filename);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			Vector<Passenger> v = new Vector<Passenger>();
			
			try
			{
				while (true)
				{
					Passenger p;
					p = (Passenger) ois.readObject();
					v.add(p);
				}
			}
			catch (EOFException e)
			{
				ois.close();
				Passenger[] array = new Passenger[v.size()];
				for (int i = 0; i < array.length; i++)
					array[i] = v.get(i);
				return array;
			}
			catch (ClassNotFoundException e)
			{System.out.println(e);}
		}
		catch (IOException e) {System.out.println(e);}
		return null;
	}
	
	public static Luggage[]
	loadLuggage(String filename)
	{
		FileInputStream fis;
		BufferedInputStream bis;
		ObjectInputStream ois;
		
		try
		{
			fis = new FileInputStream(filename);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			Vector<Luggage> v = new Vector<Luggage>();
			
			try
			{
				while (true)
				{
					Luggage l;
					l = (Luggage) ois.readObject();
					v.add(l);
				}
			}
			catch (EOFException e)
			{
				ois.close();
				Luggage[] array = new Luggage[v.size()];
				for (int i = 0; i < array.length; i++)
					array[i] = v.get(i);
				return array;
			}
			catch (ClassNotFoundException e)
			{System.out.println(e);}
		}
		catch (IOException e) {System.out.println(e);}
		return null;
	}
	
	public static Passenger
	f1(String passengersFilename, String luggageFilename)
	{
		Passenger[] ps = loadPassengers(passengersFilename);
		Luggage[] lg = loadLuggage(luggageFilename);
		
		double avg = 0;
		for (Luggage l: lg)
			avg += l.weight;
		avg /= lg.length;
		
		for (Passenger p: ps)
		{
			boolean found = true;
			for (Luggage l: lg)
			{
				if (p.id == l.id)
				{
					if (Math.abs(l.weight - avg) > 1)
					{
						found = false;
						break;
					}
				}
			}
			if (found)
				return p;
		}
		return null;
	}

}


class Passenger implements Serializable
{
	private static final long serialVersionUID = 1L;
	public int id;
	public String name;
	
	Passenger(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	public String toString()
	{
		return id + " " + name;
	}
}


class Luggage implements Serializable
{
	private static final long serialVersionUID = 1L;
	public int id;
	public String info;
	public double weight;
	
	Luggage(int id, String info, double weight)
	{
		this.id = id;
		this.info = info;
		this.weight = weight;
	}
	
	public String toString()
	{
		return id + " " + info + " " + weight;
	}
}
