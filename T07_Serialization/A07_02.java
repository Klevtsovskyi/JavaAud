package T07_Serialization;

import java.util.Arrays;

public class A07_02 {
	
	/*
	 * Багаж пасажира характеризується ім’ям 
	 * пасажира, кількістю речей і їхньою 
	 * загальною вагою. Дано файл з багажем 
	 * пасажирів. Скласти функції для:
	 * a) створення файлу з багажами пасажирів:
	 * b) зчитування файлу з багажами пасажирів.
	 * Зчитати з файлу багажі, отримати багажі 
	 * лише тих пасажирів, загальна вага яких не 
	 * перевищує задане значення та записати їх 
	 * в новий файл.
	 */
	public static void main(String[] args) {
		String fileinp = "src\\T07_Serialization\\input.luggage";
		String fileout = "src\\T07_Serialization\\output.luggage";
		
		Luggage[] array = {
			new Luggage("Alex", 5, 7.8),
			new Luggage("John", 1, 4.3),
			new Luggage("Stacy", 3, 5.4)
		};
		Luggage.write(array, fileinp);
		array = Luggage.read(fileinp);
		System.out.println(Arrays.toString(array));
	}

}
