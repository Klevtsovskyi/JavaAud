package Aud10_Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

abstract class BaseDataExchange {
	
	protected PrintStream writer;
	protected BufferedReader reader;
	
	public Data receive() throws IOException {
		String[] tmp = reader.readLine().split(" ", 2);
		System.out.println("Received: " + tmp[0] + " " + tmp[1]);
		return new Data(tmp[0], tmp[1]);
	}

	public void send(Data data) {
		writer.println(data.cmd + " " + data.msg);
		System.out.println("Sent: " + data.cmd + " " + data.msg);
	}
	
	public void send(String cmd) {
		send(new Data(cmd));
	}
	public void send(String cmd, String msg) {
		send(new Data(cmd, msg));
	}

}

class Data {
	public String cmd;
	public String msg;
	
	public Data(String cmd, String msg) {
		this.cmd = cmd;
		this.msg = msg;
	}
	
	public Data(String cmd) {
		this(cmd, "");
	}
	
}