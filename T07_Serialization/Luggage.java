package T07_Serialization;

import java.io.*;
import java.util.ArrayList;

public class Luggage implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private int count;
	private double weight;
	
	public Luggage(String name, int count, double weight) {
		this.name = name;
		this.count = count;
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return name + ": " + count + " - " + weight;
	}
	
	public static void write(Luggage[] array, String filename) {
		try {
			var f = new ObjectOutputStream( 
				new FileOutputStream(filename)
			);
			for (int i = 0; i < array.length; i++) {
				f.writeObject(array[i]);
			}
			f.close();
		} 
		catch (IOException e) {e.printStackTrace();}
	}
	
	public static Luggage[] read(String filename) {
		Luggage[] array = null;
		try {
			var f = new ObjectInputStream(
				new FileInputStream(filename)
			);
			ArrayList<Luggage> list = new ArrayList<>();
			while (true) {
				try {
					list.add((Luggage) f.readObject());
				} 
				catch (EOFException e) {break;}
			}
			f.close();
			array = list.toArray(new Luggage[0]);
		} 
		catch (ClassNotFoundException e) {e.printStackTrace();}
		catch (IOException e) {e.printStackTrace();}
		return array;
	}
}
