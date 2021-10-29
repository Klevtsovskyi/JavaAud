import java.io.*;
import java.nio.ByteBuffer;
import java.util.Arrays;


public class T07_01 {

	public static void main(String[] args) {
		double a[] = {1.0, 2.3, -5.64, 0.0, 3.21, -8.1, 7.0};
		double b[];
		
		writeToBinaryFile("input.double", a);
		b = readDoubleArrayFromBinaryFile("input.double");
		
		System.out.println(Arrays.toString(b));
		System.out.println(sum("input.double"));
		
		writeToBinaryFileV2("input.double", a);
		b = readDoubleArrayFromBinaryFileV2("input.double");
		
		System.out.println(Arrays.toString(b));
		
	}
	
	public static void 
	writeToBinaryFile(String filename, double[] array) {
		FileOutputStream fos;
		BufferedOutputStream bos;
		DataOutputStream dos;
		
		try {
			fos = new FileOutputStream(filename);
			bos = new BufferedOutputStream(fos);
			dos = new DataOutputStream(bos);
			
			for (double n: array)
				dos.writeDouble(n);
			
			dos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static double[] 
	readDoubleArrayFromBinaryFile(String filename) {
		FileInputStream fis;
		BufferedInputStream bis;
		DataInputStream dis;
		
		try {
			fis = new FileInputStream(filename);
			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);
			
			File file = new File(filename);
			long size = file.length();
			int count = (int) size / Double.BYTES;
			double array[] = new double[count];
			for (int i = 0; i < count; i++)
				array[i] = dis.readDouble();

			dis.close();
			return array;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static double sum(String filename) {
		double array[] = readDoubleArrayFromBinaryFile(filename);
		double result = 0;
		for (double n: array)
			result += n;
		return result;
	}
	
	public static void 
	writeToBinaryFileV2(String filename, double[] array) {
		FileOutputStream fos;
		BufferedOutputStream bos;
		
		try {
			fos = new FileOutputStream(filename);
			bos = new BufferedOutputStream(fos);
			
			int capacity = array.length * Double.BYTES;
			ByteBuffer bb = ByteBuffer.allocate(capacity);
			for (double n: array)
				bb.putDouble(n);
			
			bos.write(bb.array());
			
			bos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static double[] 
	readDoubleArrayFromBinaryFileV2(String filename) {
		FileInputStream fis;
		BufferedInputStream bis;
		
		try {
			fis = new FileInputStream(filename);
			bis = new BufferedInputStream(fis);
			
			byte bytes[] = bis.readAllBytes();
			int count = bytes.length / Double.BYTES;
			double array[] = new double[count];
			
			ByteBuffer bb = ByteBuffer.wrap(bytes);
			for (int i = 0; i < count; i++)
				array[i] = bb.getDouble();

			bis.close();
			return array;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
