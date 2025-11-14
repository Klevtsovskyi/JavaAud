package T10_Network;

import java.io.*;
import java.lang.module.FindException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class A10_01_Client {

    public static void main(String[] args) throws IOException {
        int port = 14110;
        String host = "localhost";

        String fileInp = "/Users/arsenklevtsovskyi/Lab/Java/Aud2025/src/T10_Network/input.txt";
        String fileOut = "/Users/arsenklevtsovskyi/Lab/Java/Aud2025/src/T10_Network/output.txt";

        Socket sock = new Socket(host, port);
        System.out.println("Connected to: " + sock.getRemoteSocketAddress());

        var reader = new BufferedReader(
            new InputStreamReader(
                sock.getInputStream(), StandardCharsets.UTF_8
        ));
        var writer = new PrintStream(
            sock.getOutputStream(), true, StandardCharsets.UTF_8
        );

        var fInp = new BufferedReader(new FileReader(fileInp, StandardCharsets.UTF_8));
        var fOut = new BufferedWriter(new FileWriter(fileOut, StandardCharsets.UTF_8));

        while (true) {
            String msg = fInp.readLine();
            if (msg == null)
                break;
            writer.println(msg);
            System.out.println("Sent: " + msg);
            msg = reader.readLine();
            System.out.println("Received: " + msg);
            fOut.write(msg + "\n");
        }

        fInp.close();
        fOut.close();
        sock.close();
        System.out.println("Disconnected from: " + sock.getRemoteSocketAddress());
    }

}
