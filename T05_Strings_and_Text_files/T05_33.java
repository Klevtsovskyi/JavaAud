import java.io.*;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;


public class T05_33 {

	public static void main(String[] args) {
		a("input.txt", "output1.txt");
		b("input.txt", "output2.txt");
		c("input.txt", "output3.txt");

	}
	
	public static void a(String input, String output) {
		Scanner inp = null;
		PrintWriter out = null;
		
		try {
			FileReader fr = new FileReader(input);
			BufferedReader br = new BufferedReader(fr);
			inp = new Scanner(br);
			
			FileWriter fw = new FileWriter(output);
			BufferedWriter bw = new BufferedWriter(fw);
			out = new PrintWriter(bw);
			
			String longestWord = "";
			while (inp.hasNext()) {
				String word = inp.next();
				if (word.length() > longestWord.length())
					longestWord = word;
			}
			out.println(longestWord);
			System.out.print(longestWord);	
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (inp != null)
				inp.close();
			if (out != null)
				out.close();
		}
	}
	
	public static void b(String input, String output) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		Path inpPath = Path.of(input);
		Path outPath = Path.of(output);
		
		try {
			br = Files.newBufferedReader(inpPath);
			bw = Files.newBufferedWriter(outPath);
			int count = 0;
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
	
	public static void c(String input, String output) {
		Path inpPath = Path.of(input);
		Path outPath = Path.of(output);
		
		try {
			List<String> lines = Files.readAllLines(inpPath);
			for (int i = 0; i < lines.size(); i++) {
				String s = lines.get(i);
				s = String.join(" ", s.trim().split("\\s+"));
				lines.set(i, s);
			}
			Files.write(outPath, lines);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
