package T10_Network;

import java.io.*;
import java.net.Socket;

public class A10_01_Client {
	
	public static void main(String[] args) throws IOException {
		String host = "127.0.0.1";
		int port = 10010;
		
		String fileinp = "src\\T10_Network\\input.txt";
		String fileout = "src\\T10_Network\\output.txt";
		
		Socket socket = new Socket(host, port);
		System.out.println("Connected to " + socket.getRemoteSocketAddress());
		
		var reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF8"));
		var writer = new PrintStream(socket.getOutputStream(), true, "UTF8");
		
		var finp = new BufferedReader(new FileReader(fileinp));
		var fout = new BufferedWriter(new FileWriter(fileout));

		while (true) {
			String msg = finp.readLine();
			writer.println(msg);
			System.out.println("Sent: " + msg);
			if (msg == null)
				break;
			msg = reader.readLine();
			System.out.println("Received: " + msg);
			fout.write(msg + "\n");
		}
		
		finp.close();
		fout.close();
		socket.close();
		System.out.println("Dissconnected from " + socket.getRemoteSocketAddress());
	}
}
