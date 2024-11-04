package T10_Network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class A10_03_Server {
	
	private A10_03_RequestHandler[] clients = {null, null, null};
	private ServerSocket server;
	
	public void run(int port) {
		server = null;
		Socket conn = null;
		try {
			server = new ServerSocket(port);
			System.out.println("Сервер запущено на " + server.getLocalSocketAddress());
		} 
		catch (IOException e) {e.printStackTrace();}
		
		while (true) {
			try {
				conn = server.accept();
				new Thread(new A10_03_RequestHandler(conn, this)).start();
			} 
			catch (IOException e) {
				System.err.println("Клієнт " + conn.getRemoteSocketAddress() + " роз'єднався");
//				e.printStackTrace();
			}
			
		}
	}
	
	public ServerSocket getServer() {return server;}
	public A10_03_RequestHandler getClient(int i) {return clients[i];}
	public void setClient(int i, A10_03_RequestHandler client) {this.clients[i] = client;}

	public static void main(String[] args) {
		new A10_03_Server().run(A10_03_Protocol.PORT);
	}
}

