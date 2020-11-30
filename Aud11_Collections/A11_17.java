package Aud11_Collections;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

/*
 * 17. Заданий файл з текстом англійською мовою. Виділити 
 * все різні слова. Для кожного слова підрахувати частоту 
 * його народження. Слова, відрізняються регістром літер, 
 * вважати різними. використовувати клас HashMap.
 */
public class A11_17
{

	public static void main(String[] args) 
	{
		Map<String, Integer> map = readWords("input.txt");
		System.out.println(map);

	}
	
	public static Map<String, Integer> 
	readWords(String filename)
	{
		Map<String, Integer> map = 
				new HashMap<String, Integer>();
		try
		{
			Scanner inp = 
					new Scanner(
					new BufferedReader(
					new FileReader(filename)));
			while (inp.hasNextLine())
			{
				String line = inp.nextLine();
				String words[] = line.trim().split("\\s+");
				for (String word: words)
				{
					if (map.containsKey(word))
					{
						int n = map.get(word);
						map.replace(word, n + 1);
					}
					else
						map.put(word, 1);
				}
			}
			inp.close();
		}
		catch (IOException e) {System.err.println(e);}
		return map;
	}

}
