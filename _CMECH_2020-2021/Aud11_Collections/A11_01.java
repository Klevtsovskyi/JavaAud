package Aud11_Collections;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
// import java.util.Collections;

/*
 * 1.Ввести рядки з файлу, записати в список. 
 * Вивести рядки в файл в зворотному порядку.
 */
public class A11_01 
{

	public static void main(String[] args) 
	{
		List<String> list = readFile("input.txt");
		// Collections.reverse(list);
		// System.out.println(list);
		reversePrint(list);
	}
	
	public static List<String> readFile(String filename)
	{
		List<String> list = new ArrayList<String>();
		try
		{
			Scanner inp = 
					new Scanner(
					new BufferedReader(
					new FileReader(filename)));
			while (inp.hasNextLine())
				list.add(inp.nextLine());
			inp.close();
		}
		catch (IOException e) {System.err.println(e);}
		return list;
	}
	
	public static void reversePrint(List<?> list)
	{
		ListIterator<?> li = list.listIterator(list.size());
		while (li.hasPrevious())
			System.out.println(li.previous());
	}
	
}
