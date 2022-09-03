import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;


public class T03_10_Student {

	public static void main(String[] args) {
		int n = 5;
		Student[] students = new Student[n];
		students[0] = new Student("Іваненко Іван");
		students[1] = new Student(
				"Петренко Петро", "2000-03-11", "мех-мат", 3);
		students[2] = new Student(
				"Олексієнко Олексій", "2001-03-11", "мех-мат", 2);
		students[3] = new Student("Микита", "2001-04-12", "фізфак", 2);
		students[4] = new Student("Олег", "2002-01-10", "мех-мат", 1);
		
		print(students);
		print(Student.getStudentsByFacultyAfterYear(
				students, "мех-мат", 2000
		));
		Student.sortByBirthDate(students);
		print(students);
	}
	
	static public void print(Student[] array) {
		for (Student s: array)
			System.out.println(s);
		System.out.println();
	}

}


class Student {
	private String name;
	private LocalDate birthdate;
	private String faculty;
	private int course;
	
	Student(String name, String birthdate, String faculty, int course) {
		this.name = name;
		this.birthdate = LocalDate.parse(birthdate);
		this.faculty = faculty;
		this.course = course;
	}
	
	Student(String name) {
		this(name, "2007-01-01", "", 1);
	}
	
	public String toString() {
		return name + ", " + birthdate + ", факультет: " +
				faculty + ", курс: " + course;
	}
	
	public String getName() {return name;}
	public void setName(String newname) {name = newname;}
	public LocalDate getBirthDate() {return birthdate;}
	public void setBirthDate(String newdate) {
		birthdate = LocalDate.parse(newdate);
	}
	
	public static Student[] getStudentsByFacultyAfterYear(
			Student[] students, String faculty, int year
	) {
		Student[] temp = new Student[students.length];
		int count = 0;
		for (Student s: students) {
			if (
					s.faculty == faculty && 
					s.birthdate.getYear() > year
			)
				temp[count++] = s;
		}
		Student[] result = new Student[count];
		for (int i = 0; i < count; i++)
			result[i] = temp[i];
		return result;
	}
	
	public static void sortByBirthDate(Student[] array) {
		Arrays.sort(array, new StudentComparatorByBirthDate());
	}
}


class StudentComparatorByBirthDate implements Comparator<Student> {
	public int compare(Student a, Student b) {
		if (a.getBirthDate().isAfter(b.getBirthDate()))
			return 1;
		else if (a.getBirthDate().isBefore(b.getBirthDate()))
			return -1;
		else
			return 0;
	}
}