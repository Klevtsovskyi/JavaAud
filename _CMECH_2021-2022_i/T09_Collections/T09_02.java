

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;


public class T09_02 {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>(100);
		String filename = "input.txt";
		Scanner inp;
		try {
			inp = new Scanner(
				new BufferedReader(new FileReader(filename))	
			);
			while (inp.hasNext()) {
				String word = inp.next();
				set.add(word.toLowerCase());
			}
			inp.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println(set);

	}

}
