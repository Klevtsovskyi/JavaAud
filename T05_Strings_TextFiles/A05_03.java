package T05_Strings_TextFiles;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class A05_03 {

	public static void main(String[] args) {
		System.out.println(
			"Директорія, де мають знаходитись файли: " + 
			System.getProperty("user.dir")
		);
		
		a("A05_03__input.txt", "A05_03a__output.txt");
		b("A05_03__input.txt", "A05_03b__output.txt");
		c("A05_03__input.txt", "A05_03c__output.txt");

	}
	/* a) знаходження найдовшого слова у файлі; */
	public static void a(String input, String output) {
		String longestWord = "";
		try {
			FileReader fr = new FileReader(input);
//			BufferedReader br = new BufferedReader(fr);
			Scanner scanner = new Scanner(fr);
			while (scanner.hasNext()) {
				String word = scanner.next();
				if (word.length() > longestWord.length())
					longestWord = word;
			}
			scanner.close();
			
			FileWriter fw = new FileWriter(output);
//			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(fw);
			pw.print(longestWord);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/* b) визначення кількості слів у файлі; */
	public static void b(String input, String output) {
		File finp = new File(input);
		File fout = new File(output);
		Path inpPath = finp.toPath();
		Path outPath = fout.toPath();
		
		int count = 0;
		try {
			BufferedReader br = Files.newBufferedReader(inpPath);
			BufferedWriter bw = Files.newBufferedWriter(outPath);
			
			while (true) {
				String line = br.readLine();
				if (line == null)
					break;
				count += line.trim().split("\\s+").length;
			}
			bw.write(Integer.toString(count));
			
			br.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* c) вилучення всіх пропусків на початку рядків, у кінці рядків і між словами (крім одного). */
	public static void c(String input, String output) {
		Path inpPath = Path.of(input);
		Path outPath = Path.of(output);
		
		try {
			List<String> list = Files.readAllLines(inpPath);
			for (int i = 0; i < list.size(); i++) {
				String line = list.get(i);
				line = String.join(" ", line.trim().split("\\s+"));
				list.set(i, line);
			}
			Files.write(outPath, list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}