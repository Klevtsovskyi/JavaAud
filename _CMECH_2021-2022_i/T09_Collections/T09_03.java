

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class T09_03 {

	public static void main(String[] args) {
		Map<String, Integer> counter = 
			new HashMap<String, Integer>(100);
		
		String filename = "input.txt";
		Scanner inp;
		try {
			inp = new Scanner(
				new BufferedReader(new FileReader(filename))	
			);
			while (inp.hasNext()) {
				String word = inp.next();
				if (counter.containsKey(word)) {
					int n = counter.get(word);
					counter.replace(word, n + 1);
				}
				else
					counter.put(word, 1);
			}
			inp.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println(counter);
	}

}
