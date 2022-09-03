

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;


public class T09_01 {

	public static void main(String[] args) {
		Path path = Path.of("input.txt");
		try {
			List<String> list = Files.readAllLines(path);
			Collections.reverse(list);
			Files.write(path, list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
