package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Simple_Socket_Server {

    private static int PORT =9999;  //Port numbers range from 0 to 65335

    public static void main(String[]args) throws IOException {

        System.out.println("Simple Socket Server.....");
        System.out.println("--------------------------");

        ServerSocket server_socket =new ServerSocket(PORT);

        try {
            while (true) {
                Socket socket = server_socket.accept();
                System.out.println("Client is connected...");

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("Hello client");

                socket.close();
            }
        }finally {
            server_socket.close();
        }

    }

}
