package T10_Network;

import java.io.*;
import java.util.Scanner;

public class A10_03_Client1 extends BaseClient {

	public A10_03_Client1(String host, int port) {
		super(host, port);
	}
	
	protected BufferedReader inputReadFile(Scanner in) {
		BufferedReader f = null;
		while (true) {
			try {
				System.out.println("Введіть шлях файлу для считування: ");
				String filepath = in.next();
				f = new BufferedReader(new FileReader(filepath));
				break;
			} catch (FileNotFoundException e) {
				System.out.println("Неможливо знайти файл. Повторіть введення.");
			}
		}
		return f;
	}
	
	protected BufferedWriter inputWriteFile(Scanner in) {
		BufferedWriter f = null;
		while (true) {
			try {
				System.out.println("Введіть шлях файлу для запису: ");
				String filepath = in.next();
				f = new BufferedWriter(new FileWriter(filepath));
				break;
			} 
			catch (IOException e) {
				System.out.println("Неможливо знайти файл. Повторіть введення.");
			}
		}
		return f;
	}

	@Override
	protected void run() throws IOException {
		send(A10_03_Protocol.CLIENT, "1");
		
		Data data = new Data("", "");
		while (true) {
			data = receive();

			if (data.cmd.equals(A10_03_Protocol.START)) {
				System.out.println("Розпочинається робота");
				break;
			} else if (data.cmd.equals(A10_03_Protocol.MESSAGE)) {
				System.out.println(data.msg);
			} else if (data.cmd.equals(A10_03_Protocol.END)) {
				System.out.println(data.msg);
				return;
			}
		}

		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("Режими роботи [0 - розпочати, 1 - завершити]: ");
			String mode = in.next();
			if (mode.equals("1")) {
				send(A10_03_Protocol.END);
				break;
			}
			else if (mode.equals("0")) {
				var finp = inputReadFile(in);
				var fout = inputWriteFile(in);
				send(A10_03_Protocol.START);
				while (true) {
					String line = finp.readLine();
					if (line == null)
						break;
					send(A10_03_Protocol.QUESTION, line.stripTrailing());
					data = receive();
					fout.append(data.msg + "\n");
				}
				finp.close();
				fout.close();
			}
			else
				System.out.println("Невідома команда");
		}
		in.close();
	}

	public static void main(String[] args) {
		String host = "127.0.0.1";
		new A10_03_Client1(host, A10_03_Protocol.PORT);
	}
}
