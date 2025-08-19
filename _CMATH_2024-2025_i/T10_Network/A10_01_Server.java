package T10_Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Скласти програми сервера та клієнта для розв’язання такої задачі. Клієнт
читає з текстового файлу та відправляє на сервер рядки. Сервер до кожного
такого рядка додає номер та повертає його клієнту. Клієнт зберігає рядки у
новому файлі.
 */
public class A10_01_Server {
	
	public static void main(String[] args) throws IOException {
		int port = 10010;
		
		try (ServerSocket server = new ServerSocket(port)) {
			System.out.println("Server runs on " + server.getLocalSocketAddress());
			
			while (true) {
				Socket conn = server.accept();
				System.out.println("Connected from " + conn.getRemoteSocketAddress());
				
				var reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF8"));
				var writer = new PrintStream(conn.getOutputStream(), true, "UTF8");
				
				int i = 0;
				while (true) {
					String msg = reader.readLine();
					System.out.println("Received: " + msg);
					if (msg == null)
						break;
					msg = ++i + " " + msg;
					writer.println(msg);
					System.out.println("Sent: " + msg);
				}
				
				conn.close();
				System.out.println("Dissconnected from " + conn.getRemoteSocketAddress());
			}
		}
	}
}
