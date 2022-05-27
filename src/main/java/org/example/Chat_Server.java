package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Chat_Server {

    private static int PORT =9001;  //Port numbers range from 0 to 65335

    public static void main(String[]args) throws IOException {

        System.out.println("Simple Socket Server.....");
        System.out.println("--------------------------");

        ServerSocket server_socket =new ServerSocket(PORT);
        Scanner scan = new Scanner(System.in);


        try {
            while (true) {
                Socket socket = server_socket.accept();
                System.out.println("Client is connected...");

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));


                try{
                    while (true){
                        System.out.print("Server : ");
                        String input = scan.nextLine();
                        out.println(input);

                        String output =in.readLine();
                        System.out.println("Client says : "+input);
                    }
                }finally {
                    socket.close();
                    out.println("Hello client");
                    in.close();
                }

            }
        }finally {
            server_socket.close();
        }

    }

}
