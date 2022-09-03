import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class T07_07 {

	public static void main(String[] args) {
		Passenger ps[] = {
			new Passenger(1, "A"),
			new Passenger(2, "B"),
			new Passenger(3, "C")
		};
		Luggage ls[] = {
			new Luggage(1, 3, 30.0),
			new Luggage(2, 1, 7.1),
			new Luggage(3, 2, 8.2)
		};
		
		write("input.passenger", ps);
		write("input.luggage", ls);
		
		ps = readPassengersFromFile("input.passenger");
		System.out.println(Arrays.toString(ps));
		ls = readLuggageFromFile("input.luggage");
		System.out.println(Arrays.toString(ls));
		
		System.out.println(a("input.passenger", "input.luggage"));

	}
	
	public static void write(String filename, Passenger ps[]) {
		FileOutputStream fos;
		BufferedOutputStream bos;
		ObjectOutputStream oos;
		
		try {
			fos = new FileOutputStream(filename);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			
			for (Passenger p: ps)
				oos.writeObject(p);
			
			oos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void write(String filename, Luggage ls[]) {
		FileOutputStream fos;
		BufferedOutputStream bos;
		ObjectOutputStream oos;
		
		try {
			fos = new FileOutputStream(filename);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			
			for (Luggage l: ls)
				oos.writeObject(l);
			
			oos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Passenger[] 
	readPassengersFromFile(String filename) {
		FileInputStream fis;
		BufferedInputStream bis;
		ObjectInputStream ois;
		
		try {
			fis = new FileInputStream(filename);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			
			List<Passenger> list = new ArrayList<Passenger>();
			try {
				while (true) {
					list.add((Passenger) ois.readObject());
				}		
			} catch (EOFException e) {
				ois.close();
				return list.toArray(new Passenger[0]);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Luggage[] 
	readLuggageFromFile(String filename) {
		FileInputStream fis;
		BufferedInputStream bis;
		ObjectInputStream ois;
		
		try {
			fis = new FileInputStream(filename);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			
			List<Luggage> list = new ArrayList<Luggage>();
			try {
				while (true) {
					list.add((Luggage) ois.readObject());
				}		
			} catch (EOFException e) {
				ois.close();
				return list.toArray(new Luggage[0]);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Passenger 
	a(String passengersFilename, String luggageFilename) {
		Passenger ps[] = readPassengersFromFile(passengersFilename);
		Luggage ls[] = readLuggageFromFile(luggageFilename);
		
		int luggageCount = 0;
		double luggageWeight = 0;
		for (Luggage l: ls) {
			luggageCount += l.count;
			luggageWeight += l.weight;
		}
		double averageWeight = luggageWeight / luggageCount;
//		System.out.println(averageWeight);
		for (int i = 0; i < ps.length; i++) {
			if (
				Math.abs(
					(ls[i].weight / ls[i].count) - averageWeight
				) <= 1
			)
			return ps[i];
		}
		return null;
	}
}



class Passenger implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public int id;
	public String name;
	
	Passenger(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String toString() {
		return id + " " + name;
	}
}


class Luggage implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public int id;
	public int count;
	public double weight;
	
	Luggage(int id, int count, double weight) {
		this.id = id;
		this.count = count;
		this.weight = weight;
	}
	
	public String toString() {
		return id + " " + count + " " + weight;
	}
}