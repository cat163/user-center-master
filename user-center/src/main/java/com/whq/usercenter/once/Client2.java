package com.whq.usercenter.once;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public static void main(String[] args) {
        new Client2().runClient();
    }

    public void runClient() {
        Scanner scanner = new Scanner(System.in);
        try {
            socket = new Socket("localhost", 1234);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            System.out.print("Enter your username: ");
            String username = scanner.nextLine();

            out.println(username);

            // Start a new thread to listen for incoming messages
            Thread receiveThread = new Thread(new ReceiveThread());
            receiveThread.start();

            // Read user input and send it to the server
            String inputLine;
            while ((inputLine = scanner.nextLine()) != null) {
                out.println(inputLine);
                System.out.println("1");
            }

            in.close();
            out.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class ReceiveThread implements Runnable {
        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
