package T10_Network;

import java.io.IOException;

public class A10_03_Client2 extends BaseClient {

	public A10_03_Client2(String host, int port) {
		super(host, port);
	}

	@Override
	protected void run() throws IOException {
		send(A10_03_Protocol.CLIENT, "2");
		
		int i = 0;
		while (true) {
			Data data = receive();
			
			if (data.cmd.equals(A10_03_Protocol.START)) {
				i = 0;
			} else if (data.cmd.equals(A10_03_Protocol.QUESTION)) {
				send(A10_03_Protocol.ANSWER, ++i + " " + data.msg);
			} else if (data.cmd.equals(A10_03_Protocol.MESSAGE)) {
				System.out.println(data.msg);
			} else if (data.cmd.equals(A10_03_Protocol.END)) {
				System.out.println(data.msg);
				return;
			}
		}
	}

	public static void main(String[] args) {
		String host = "127.0.0.1";
		new A10_03_Client2(host, A10_03_Protocol.PORT);
	}
}
