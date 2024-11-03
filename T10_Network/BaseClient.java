package Aud10_Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

abstract public class BaseClient extends BaseDataExchange {
	
	protected Socket socket;
	
	public BaseClient(String host, int port) {
		try {init(host, port);} 
		catch (IOException e) {
			System.err.println("Не можу приєднатися до сервера");
//			e.printStackTrace();
		}
		try {run();} 
		catch (IOException e) {
//			e.printStackTrace();
			System.err.println("Сервер роз'єднав з'єднання");
		}
		try {finish();} 
		catch (IOException e) {
//			e.printStackTrace();
		}
	}
	
	protected void init(String host, int port) throws IOException {
		socket = new Socket(host, port);
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF8"));
		writer = new PrintStream(socket.getOutputStream(), true, "UTF8");
		System.out.println("Під'єднано до " + socket.getRemoteSocketAddress());
	}
	
	abstract protected void run() throws IOException;
	
	protected void finish() throws IOException {
		if (socket != null) socket.close();
		System.out.println("Роз'єднано з " + socket.getRemoteSocketAddress());
	}
}
