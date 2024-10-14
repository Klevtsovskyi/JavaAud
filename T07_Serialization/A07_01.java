package T07_Serialization;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class A07_01 {
	
	/*
	 * Створити бінарний файл F, компонентами якого є цілі числа. 
	 * Описати функцію, що зчитує масив цілих чисел з цього файлу. 
	 * Побудувати файл G, який містив би всі компоненти файлу F, що є парними числами.
	 */
	public static void main(String[] args) {
		String fileinp = "src\\T07_Serialization\\input.int32";
		String fileout = "src\\T07_Serialization\\output.int32";
		
		int[] a = {1, 0, 37, -54, 23, 123, 876, 753, 423, 100, -1};
		write(a, fileinp);
		
		int[] b = read(fileinp);
		System.out.println(Arrays.toString(b));
		
		int[] c = new int[b.length];
		int j = 0;
		for (int i = 0; i < b.length; i++) {
			if (b[i] % 2 == 0)
				c[j++] = b[i];
		}
		int[] d = Arrays.copyOf(c, j);
		writeWithByteBuffer(d, fileout);
		
		b = readWithByteBuffer(fileout);
		System.out.println(Arrays.toString(b));
	}

	public static void write(int[] array, String filename) {
		try {
			var f = new DataOutputStream( 
				new FileOutputStream(filename)
			);
			for (int i = 0; i < array.length; i++) {
				f.writeInt(array[i]);
			}
			f.close();
		} 
		catch (IOException e) {e.printStackTrace();}
	}
	
	public static int[] read(String filename) {
		int[] array = null;
		try {
			var f = new DataInputStream( 
				new FileInputStream(filename)
			);
			File file = new File(filename);
			int size = (int) (file.length() / Integer.BYTES);
			array = new int[size];
			for (int i = 0; i < array.length; i++) {
				array[i] = f.readInt(); 
			}
			f.close();
		} 
		catch (IOException e) {e.printStackTrace();}
		return array;
	}
	
	public static void writeWithByteBuffer(int[] array, String filename) {
		try {
			var f = new FileOutputStream(filename);
			ByteBuffer bb = ByteBuffer.allocate(array.length * Integer.BYTES);
			for (int i = 0; i < array.length; i++) {
				bb.putInt(array[i]);
			}
			f.write(bb.array());
			f.close();
		}
		catch (IOException e) {e.printStackTrace();}
	}
	
	public static int[] readWithByteBuffer(String filename) {
		int[] array = null;
		try {
			var f = new FileInputStream(filename);
			ByteBuffer bb = ByteBuffer.wrap(f.readAllBytes());
			int size = bb.capacity() / Integer.BYTES;
			array = new int[size];
			for (int i = 0; i < array.length; i++) {
				array[i] = bb.getInt();
			}
			f.close();
		}
		catch (IOException e) {e.printStackTrace();}
		return array;
	}
}
