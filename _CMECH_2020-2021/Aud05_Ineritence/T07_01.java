

public class T07_01 
{
	public static void main(String[] args)
	{
		Encyclopedia e = new Encyclopedia("title1", "text");
		Durectory d = new Durectory("title2", "text");
		e.print();
		d.print();
	}
}


interface Edition
{
	void print();
}


abstract class Book implements Edition
{
	private String title;
	private String text;
	
	Book(String title, String text)
	{
		this.title = title;
		this.text = text;
	}
	
	public void print()
	{
		System.out.print(title + ":" + text + "\n");
	}
	
}

final class Encyclopedia extends Book
{
	Encyclopedia(String title, String text)
	{
		super(title, text);
	}
}

final class Durectory extends Book
{
	Durectory(String title, String text)
	{
		super(title, text);
	}
}