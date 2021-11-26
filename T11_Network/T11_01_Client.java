import java.io.*;
import java.net.Socket;


public class T11_01_Client {

	public static void main(String[] args) {
		String inp = "input.txt";
		String out = "output.txt";
		
		String host = "127.0.0.1";
		int port = 20000;
		try {	
			Socket s = new Socket(host, port);
			System.out.println("=== Client ===");
			System.out.println("Connected to " + s.getInetAddress());
			
			BufferedReader socketReader = new BufferedReader(
				new InputStreamReader(s.getInputStream())
			);
			PrintStream socketWriter = new PrintStream(
				s.getOutputStream()
			);
			
			BufferedReader inputFile = new BufferedReader(new FileReader(inp));
			BufferedWriter outputFile = new BufferedWriter(new FileWriter(out));
			
			while (true) {
				String msg = inputFile.readLine();
				System.out.printf("\"%s\" sent\n", msg);
				socketWriter.println(msg);
				if (msg == null)
					break;
				msg = socketReader.readLine();
				System.out.printf("\"%s\" received\n", msg);
				outputFile.write(msg + "\n");
			}
			
			inputFile.close();
			outputFile.close();
			
			socketReader.close();
			socketWriter.close();
			s.close();
			System.out.println("Disconnected");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
