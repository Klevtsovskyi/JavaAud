

import java.util.Arrays;


public class T04_01_Text
{
	public static void main(String[] args)
	{
		Word w0 = new Word("Word");
		Word w1 = new Word("Word");
		System.out.println(w0);
		System.out.println(w0 == w1);
		System.out.println(w0.equals(w1));
		System.out.println(w0.hashCode());
		System.out.println(w1.hashCode());
		
		System.out.println();
		
		Word[] words0 = new Word[2];
		words0[0] = w0;
		words0[1] = w1;
		Word[] words1 = {new Word("Hello"), new Word("bye")};
		
		Sentence s0, s1, s2;
		s0 = new Sentence(words0); // "Word Word"
		s1 = new Sentence(words1); // "Hello bye"
		s2 = new Sentence("Hello bye"); // "Hello bye"
		s0.addWord(new Word("deer"));
		System.out.println(s0);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s0.equals(s1));
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		System.out.println();
		
		Sentence[] ss0 = new Sentence[2];
		ss0[0] = s0;
		ss0[1] = s1;
		Sentence[] ss1 = {new Sentence("Word Word deer")};
		Sentence[] ss2 = {new Sentence("Hello bye")};
		
		Text t0, t1, t2;
		t0 = new Text(ss0, "text 1");
		t1 = new Text(ss1, "text 1");
		t2 = new Text(ss2, "text 2");
		t1.addSentence(new Sentence("Hello bye"));
		System.out.println(t0);
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t0.equals(t1));
		System.out.println(t0.equals(t2));
		
	}
}


class Word extends Object
{
	private String word;
	
	Word(String word) {this.word = word;}
	
	public String toString() {return this.word;}
	
	public boolean equals(Object obj)
	{
		if (!(obj instanceof Word))
			return false;
		else
			return this.word.equals(((Word) obj).word);
	}
	
	public int hashCode() {return this.word.hashCode();}	
}


class Sentence
{
	private Word[] words;
	
	Sentence (Word[] words) {this.words = words;}
	
	Sentence(String str)
	{
		String[] strs = str.split(" ");
		Word[] words = new Word[strs.length];
		for (int i = 0; i < words.length; i++)
			words[i] = new Word(strs[i]);
		this.words = words;
	}
	
	public String toString()
	{
		String s = "";
		int i = 0;
		for (; i < this.words.length - 1; i++)
			s += words[i] + " ";
		return s + this.words[i] + ". ";
		//return Arrays.toString(this.words);
	}
	
	public boolean equals(Object obj)
	{
		if (!(obj instanceof Sentence))
			return false;
		return Arrays.equals(this.words, ((Sentence) obj).words);
	}
	
	public int hashCode()
	{
		return Arrays.hashCode(this.words);
	}
	
	public void addWord(Word newword)
	{
		Word[] newwords = new Word[this.words.length + 1];
		int i = 0;
		for (; i < this.words.length; i++)
			newwords[i] = this.words[i];
		newwords[i] = newword;
		this.words = newwords;
	}
}

class Text
{
	private Sentence[] sentences;
	private String header;
	
	Text(Sentence[] sents, String header)
	{
		this.sentences = sents;
		this.header = header;
	}
	
	public String toString()
	{
		String s = this.header + ".\n";
		int i = 0;
		for (; i <this.sentences.length; i++)
			s += this.sentences[i];
		return s;
		//return Arrays.toString(this.sentences);
	}
	
	public boolean equals(Object obj)
	{
		if (!(obj instanceof Text))
			return false;
		return (this.header == ((Text) obj).header &&
				Arrays.equals(this.sentences, ((Text) obj).sentences));
	}
	
	public int hasshCode()
	{
		return Arrays.hashCode(this.sentences) + this.header.hashCode();
	}
	
	public void addSentence(Sentence newsent)
	{
		Sentence[] newsents = new Sentence[this.sentences.length + 1];
		int i = 0;
		for (; i < this.sentences.length; i++)
			newsents[i] = this.sentences[i];
		newsents[i] = newsent;
		this.sentences = newsents;
	}
}
