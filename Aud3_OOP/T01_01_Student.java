

import java.time.LocalDate;


public class T01_01_Student 
{
	public static void main(String[] args)
	{
		Student[] students = new Student[5];
		students[0] = new Student(1, "Іванов Іван", "2001-03-30", "", "", "Мех-мат", 3, 2);
		students[1] = new Student("Петренко Петро");
		students[2] = new Student(2, "Олексієнко Олексій", "2002-01-01", "Фізфак", 2, 1);
		students[3] = new Student(3, "Іванова Іванна", "2003-01-01", "Фізфак", 1, 1);
		students[4] = new Student(4, "Миколаєнко Микола", "2001-01-01", "Мех-мат", 3, 1);	
		for (int i = 0; i < students.length; i++)
			System.out.println(students[i]);
		
		System.out.println("\nСтуденти з Мех-мату: ");
		for (Student student: getStudentsByFaculty(students, "Мех-мат"))
			System.out.println(student);
		
		System.out.println("\nСтуденти 1-го курсу: ");
		for (Student student: Student.getStudentsByCourse(students, 1))
			System.out.println(student);
		
		System.out.println("\nСтуденти, які народились після 2002: ");
		for (Student student: Student.getStudentsByYear(students, 2002))
			System.out.println(student);
		
		
	}
	
	public static Student[] getStudentsByFaculty(Student[] students, String faculty)
	{
		Student[] result;
		int nums[] = new int[students.length];
		int count = 0;
		for (int i = 0; i < students.length; i++)
		{
			if (students[i].getFaculty() == faculty)
				nums[count++] = i;
		}
		result = new Student[count];
		for (int i = 0; i < count; i++)
			result[i] = students[nums[i]];
		return result;
	}
}

class Student
{
	private int id;
	private String name;
	private LocalDate birthdate;
	private String adress;
	private String phone;
	private String faculty;
	private int course;
	private int group;
	
	Student(int id, String name, String date, String adress, String phone, 
			String faculty, int course, int group)
	{
		this.id = id;
		this.name = name;
		this.birthdate = LocalDate.parse(date);
		this.adress = adress;
		this.phone = phone;
		this.faculty = faculty;
		this.course = course;
		this.group = group;
	}
	
	Student(String name)
	{
		this(0, name, "2020-01-01", "", "", "", 1, 1);
	}
	
	Student(int id, String name, String date, 
			String faculty, int course, int group)
	{
		this(id, name, date, "", "", faculty, course, group);
	}
	
	public String toString()
	{
		return this.id + " " + this.name;
	}
	
	public void setId(int id) {this.id = id;}
	public int getId() {return this.id;}
	
	public void setFaculty(String faculty ) {this.faculty = faculty;}
	public String getFaculty() {return this.faculty;}
	
	public static Student[] getStudentsByCourse(Student[] students, int course)
	{
		Student[] result;
		int nums[] = new int[students.length];
		int count = 0;
		for (int i = 0; i < students.length; i++)
		{
			if (students[i].course == course)
				nums[count++] = i;
		}
		result = new Student[count];
		for (int i = 0; i < count; i++)
			result[i] = students[nums[i]];
		return result;
	}
	
	public static Student[] getStudentsByYear(Student[] students, int year)
	{
		Student[] result;
		int nums[] = new int[students.length];
		int count = 0;
		for (int i = 0; i < students.length; i++)
		{
			if (students[i].birthdate.getYear() > year)
				nums[count++] = i;
		}
		result = new Student[count];
		for (int i = 0; i < count; i++)
			result[i] = students[nums[i]];
		return result;
	}
}