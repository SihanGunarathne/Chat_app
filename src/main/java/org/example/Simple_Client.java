package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.UnknownHostException;


public class Simple_Client {

    private static int PORT =9999;  //Port numbers range from 0 to 65335

    public static void main(String[]args) throws IOException {

        System.out.println("Simple Socket Server.....");
        System.out.println("--------------------------");

        //127.0.0.1
        InetAddress ipAddress = null;
        try {
            ipAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

        Socket socket = new Socket(ipAddress,PORT);

        System.out.println("Server is conected...");

        InputStreamReader isr = new InputStreamReader(socket.getInputStream());

        BufferedReader in = new BufferedReader(isr);

        String input = in.readLine();

        System.out.println("Server Says : "+ input);

        socket.close();
        in.close();


    }
}
