package cl.exql.simple.container;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleWebContainer {

    private final int port;

    public SimpleWebContainer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket socket = serverSocket.accept();
            Thread socketHandler = new SocketHandler(socket);
            socketHandler.start();
        }
    }


    public static void main(String[] args) throws IOException {
        SimpleWebContainer swc = new SimpleWebContainer(4567);
        swc.start();
    }
}
