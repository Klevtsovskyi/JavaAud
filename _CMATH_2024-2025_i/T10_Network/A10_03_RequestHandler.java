package T10_Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class A10_03_RequestHandler extends BaseDataExchange implements Runnable {
	
	protected int no;
	protected Socket socket;
	protected A10_03_Server server;
	
	public A10_03_RequestHandler(Socket socket, A10_03_Server server) {
		this.socket = socket;
		this.server = server;
	}
	
	@Override
	public void run() {
		try {init();} 
		catch (IOException e) {
			System.err.println("Не вдалося з'єднатися з клієнтом");
			return;
		}
		try {handle();} 
		catch (Exception e) {
			System.err.println("Клієнт " + socket.getRemoteSocketAddress() + " роз'єднався");
		}
		try {finish();} 
		catch (IOException e) {}
	}
	
	protected boolean noClient(int i) {
		return server.getClient(i) == null;
	}
	protected void setClient(int i, A10_03_RequestHandler client) {
		no = i;
		server.setClient(i, client);
	}
	
	protected void init() throws IOException {
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF8"));
		writer = new PrintStream(socket.getOutputStream(), true, "UTF8");
		System.out.println("Під'єднано " + socket.getRemoteSocketAddress());
	}
	
	protected void handle() throws IOException {
		Data data = receive();
		int i = Integer.parseInt(data.msg);
		if (data.cmd.equals(A10_03_Protocol.CLIENT) && noClient(i)) {
			setClient(i, this);
			System.out.println("Під'єднано " + socket.getLocalSocketAddress() + " як клієнта " + i);
		} else {
			send(A10_03_Protocol.END, "Клієнта " + i + " вже під'єднано");
			return;
		}
		if (noClient(1))
			send(A10_03_Protocol.MESSAGE, "Очікуємо на клієнта 1");
		if (noClient(2))
			send(A10_03_Protocol.MESSAGE, "Очікуємо на клієнта 2");
		if (!noClient(1) && !noClient(2))
			server.getClient(1).send(A10_03_Protocol.START);
		
		while (true) {
			data = receive();
			
			if (data.cmd.equals(A10_03_Protocol.START))
				server.getClient(2).send(A10_03_Protocol.START);
			else if (data.cmd.equals(A10_03_Protocol.QUESTION))
				server.getClient(2).send(A10_03_Protocol.QUESTION, data.msg);
			else if (data.cmd.equals(A10_03_Protocol.ANSWER))
				server.getClient(1).send(A10_03_Protocol.ANSWER, data.msg);
			else if (data.cmd.equals(A10_03_Protocol.END))
				break;
		}
	}
	
	protected void finish() throws IOException {
		if (socket != null) {
			socket.close();
			System.out.println("Роз'єднано з " + socket.getRemoteSocketAddress() + " як клієнта " + no);
		}
		setClient(no, null);
	}
}
