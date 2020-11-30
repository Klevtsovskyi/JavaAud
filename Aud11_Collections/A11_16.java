package Aud11_Collections;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * 16. Заданий файл з текстом англійською мовою. 
 * Виділити все різні слова. Слова, що відрізняються 
 * тільки регістром літер, вважати однаковими. 
 * Використовувати клас HashSet.
 */
public class A11_16 
{

	public static void main(String[] args) 
	{
		Set<String> set = readWords("input.txt");
		System.out.println(set);

	}
	
	public static Set<String> readWords(String filename)
	{
		Set<String> set = new HashSet<String>();
		try
		{
			Scanner inp = 
					new Scanner(
					new BufferedReader(
					new FileReader(filename)));
			while (inp.hasNextLine())
			{
				String line = inp.nextLine();
				String words[] = line.split(" ");
				for (String word: words)
					set.add(word);
			}
			inp.close();
		}
		catch (IOException e) {System.err.println(e);}
		return set;
	}

}
