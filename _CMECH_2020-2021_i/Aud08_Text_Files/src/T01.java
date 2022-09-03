

import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class T01 
{
	public static void main(String[] args) 
	{
		f1LongestWord1("input.txt", "output_t01_f1_1.txt");
		f1LongestWord2("input.txt", "output_t01_f1_2.txt");
		f2CountOfWords("input.txt", "output_t01_f2.txt");
		f3RemoveSpaces("input.txt", "output_t01_f3.txt", 1);
		f5("input.txt", "output_t01_f5.txt");

	}
	

	public static void f1LongestWord1(String input, String output)
	{
		Scanner inp = null;
		PrintWriter out = null; // System.out
		
		try
		{
			FileReader fr = new FileReader(input);
			BufferedReader bf = new BufferedReader(fr);
			inp = new Scanner(bf);
			
			FileWriter fw = new FileWriter(output);
			BufferedWriter bw = new BufferedWriter(fw);
			out = new PrintWriter(bw);
			
			String longestWord = "";
			while (inp.hasNext())
			{
				String line = inp.nextLine();
				String word = T01_RegExp.f1LongestWord1(line);
				if (word.length() > longestWord.length())
					longestWord = word;
			}
			out.print(longestWord);
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
		finally
		{
			if (inp != null)
				inp.close();
			if (out != null)
				out.close();
		}
	}
	
	public static void f1LongestWord2(String input, String output)
	{
		Scanner inp = null;
		PrintWriter out = null; // System.out
		
		try
		{
			FileReader fr = new FileReader(input);
			BufferedReader bf = new BufferedReader(fr);
			inp = new Scanner(bf);
			
			FileWriter fw = new FileWriter(output);
			BufferedWriter bw = new BufferedWriter(fw);
			out = new PrintWriter(bw);
			
			String longestWord = "";
			while (inp.hasNext())
			{
				String word = inp.next();
				if (word.length() > longestWord.length())
					longestWord = word;
			}
			out.print(longestWord);
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
		finally
		{
			if (inp != null)
				inp.close();
			if (out != null)
				out.close();
		}
		
	}

	public static void f2CountOfWords(String input, String output)
	{
		BufferedReader br;
		BufferedWriter bw;
		
		try
		{
			Path inpPath = Path.of(input);
			Path outPath = Path.of(output);
			
			br = Files.newBufferedReader(inpPath);
			bw = Files.newBufferedWriter(outPath);
			
			int count = 0;
			while (true)
			{
				String line = br.readLine();
				if (line == null)
					break;
				count += T01_RegExp.f2CountOfWords(line);
			}
			bw.write(Integer.toString(count));
			
			br.close();
			bw.close();
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
	}
	
	public static void f3RemoveSpaces(String input, String output, int n)
	{
		File finp = new File(input);
		File fout = new File(output);
		
		Path outPath = fout.toPath();
		
		try
		{
			RandomAccessFile rafinp =
					new RandomAccessFile(finp, "r");
			
			BufferedWriter bw = Files.newBufferedWriter(outPath);
			PrintWriter out = new PrintWriter(bw);
			
			while (true)
			{
				String line = rafinp.readLine();
				if (line == null)
					break;
				String[] words = line.split("\\s+");
				for (String word: words)
				{
					if (word.length() > n)
						out.write(word + " ");
				}
			}
			rafinp.close();
			out.close();
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
	}
	
	public static void f5(String input, String output)
	{
		Path pathInp = Path.of(input);
		Path pathOut = Path.of(output);
		
		try
		{
			List<String> lines =  Files.readAllLines(pathInp);
			for (int i = 0; i < lines.size(); i++)
			{
				String s = T01_RegExp.f5(lines.get(i));
				s = s.trim();
				lines.set(i, s);
			}
			Files.write(pathOut, lines);
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
	}
}
