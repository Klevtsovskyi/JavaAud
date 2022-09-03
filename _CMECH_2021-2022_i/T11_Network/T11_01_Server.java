import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;


public class T11_01_Server {

	public static void main(String[] args) {
		int port = 20000;
		try {
			ServerSocket ss = new ServerSocket(port);
			System.out.println("=== Server ===");
			
			Socket conn = ss.accept();
			System.out.println("Connected from " + conn.getInetAddress());
			
			BufferedReader connReader = new BufferedReader(
				new InputStreamReader(conn.getInputStream())
			);
			PrintStream connWriter = new PrintStream(
				conn.getOutputStream()
			);
			
			int i = 1;
			while (true) {
				String msg = connReader.readLine();
				System.out.printf("\"%s\" received\n", msg);
				if (msg == null)
					break;
				msg = i + " " + msg;
				connWriter.println(msg);
				System.out.printf("\"%s\" sent\n", msg);
				i++;
			}
			
			connReader.close();
			connWriter.close();
			conn.close();
			System.out.println("Client disconnected");
			
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
