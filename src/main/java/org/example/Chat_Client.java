package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Chat_Client {

    private static int PORT =9001;  //Port numbers range from 0 to 65335

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

        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

        Scanner scan = new Scanner(System.in);

        try{
            while (true){
                String input = in.readLine();
                System.out.println("Server Says : "+ input);

                System.out.print("Client : ");
                String output = scan.nextLine();
                out.println(output);

            }
        }finally {
            socket.close();
            in.close();
            out.close();

        }

    }
}
