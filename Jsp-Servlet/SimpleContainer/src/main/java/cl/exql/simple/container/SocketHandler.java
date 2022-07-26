package cl.exql.simple.container;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketHandler extends Thread {

    private Socket socket;

    public SocketHandler(Socket s) {
        this.socket = s;
    }

    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = br.readLine();
            while (!line.isEmpty()) {
                System.out.println(line);
                line = br.readLine();
            }
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            out.println();
        } catch (RuntimeException | IOException e) {

        }
    }
}
