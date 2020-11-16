

import java.io.*;
import java.util.Vector;
import java.util.Arrays;
import java.nio.ByteBuffer;


public class T01 
{

	public static void main(String[] args) 
	{
		double[] a = {1.0, 2.1, 3.2, -4.3, -0.5, 0.76};
		double[] b;
		
		writeDoubleArrayV1("input.double", a);
		b = readDoubleArrayV1("input.double");
		System.out.println(Arrays.toString(b));
		
		writeDoubleArrayV2("input.double", a);
		b = readDoubleArrayV2("input.double");
		System.out.println(Arrays.toString(b));
		
		System.out.println(f1Sum("input.double"));
	}
	
	public static void 
	writeDoubleArrayV1(String filename, double[] array)
	{
		FileOutputStream fos;
		BufferedOutputStream bos;
		DataOutputStream dos;
		
		try
		{
			fos = new FileOutputStream(filename);
			bos = new BufferedOutputStream(fos);
			dos = new DataOutputStream(bos);
			
			for (int i = 0; i < array.length; i++)
				dos.writeDouble(array[i]);
			
			dos.close();
		}
		catch (IOException e) {System.out.println(e);}
	}
	
	public static double[]
	readDoubleArrayV1(String filename)
	{
		FileInputStream fis;
		BufferedInputStream bis;
		DataInputStream dis;
		
		try
		{
			fis = new FileInputStream(filename);
			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);
			Vector<Double> v = new Vector<Double>();
			
			try
			{
				while (true)
				{
					Double d = dis.readDouble();
					v.add(d);
				}
			}
			catch (EOFException e)
			{
				dis.close();
				double[] array = new double[v.size()];
				for (int i = 0; i < array.length; i++)
					array[i] = (double) v.get(i);
				return array;
			}
		}
		catch (IOException e) {System.out.println(e);}
		return null;
	}
	
	public static double f1Sum(String filename)
	{
		double[] array = readDoubleArrayV1(filename);
		double s = 0;
		for(double d: array)
			s += d;
		return s;
	}
	
	public static void 
	writeDoubleArrayV2(String filename, double[] array)
	{
		FileOutputStream fos;
		BufferedOutputStream bos;
		
		try
		{
			fos = new FileOutputStream(filename);
			bos = new BufferedOutputStream(fos);
			
			int capacity = array.length * Double.BYTES;
			ByteBuffer bb = ByteBuffer.allocate(capacity);
			for (int i = 0; i < array.length; i++)
				bb.putDouble(array[i]);
			
			bos.write(bb.array());
			bos.close();
		}
		catch (IOException e) {System.out.println(e);}
	}
	
	public static double[]
	readDoubleArrayV2(String filename)
	{
		FileInputStream fis;
		BufferedInputStream bis;
		
		try
		{
			fis = new FileInputStream(filename);
			bis = new BufferedInputStream(fis);
			
			byte[] bytes = bis.readAllBytes();
			// System.out.println(Arrays.toString(bytes));
			int n = bytes.length / Double.BYTES;
			double[] array = new double[n];
			
			for (int i = 0; i < n; i++)
			{
				ByteBuffer bb;
				bb = ByteBuffer.wrap(
						bytes,
						i * Double.BYTES, 
						Double.BYTES);
				array[i] = bb.getDouble();
			}
			bis.close();
			return array;
		}
		catch (IOException e) {System.out.println(e);}
		return null;
	}

}
