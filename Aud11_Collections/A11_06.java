package Aud11_Collections;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

/*
 * 14. Ввести рядки з файлу, записати в список ArrayList. 
 * виконати сортування рядків, використовуючи метод sort () 
 * з класу Collections.
 */
public class A11_06 
{

	public static void main(String[] args) 
	{
		List<String> list = readFile("input.txt");
		// Collections.sort(list);
		Collections.sort(list, new StringComparator());
		System.out.println(list);
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
}

class StringComparator implements Comparator<String>
{
	public int compare(String a, String b)
	{
		if (a.length() > b.length())
			return 1;
		else if (a.length() == b.length())
			return 0;
		else 
			return -1;
		// return a.compareTo(b);
	}
}
