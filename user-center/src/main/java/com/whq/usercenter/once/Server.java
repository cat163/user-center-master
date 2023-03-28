package com.whq.usercenter.once;

import java.net.*;
import java.io.*;
import java.util.*;

public class Server {
   private ServerSocket serverSocket;
   private List<ChatThread> chatThreads = new ArrayList<>();
 
   public static void main(String[] args) {
      new Server().runServer();
   }
 
   public void runServer() {
      try {
         serverSocket = new ServerSocket(1234);
         System.out.println("Server started on port 1234...");
         while (true) {
            Socket clientSocket = serverSocket.accept();
            ChatThread ct = new ChatThread(clientSocket);
            chatThreads.add(ct);
            ct.start();
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
 
   public void broadcast(String message) {
      for (ChatThread ct : chatThreads) {
         ct.sendMessage(message);
      }
   }

   class ChatThread extends Thread {
      private Socket clientSocket;
      private BufferedReader in;
      private PrintWriter out;
      public ChatThread(Socket clientSocket) {
         this.clientSocket = clientSocket;
      }
 
      public void run() {
         try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            String username = in.readLine();
            System.out.println("New user connected: " + username);
            broadcast(username + " has joined the chat.");
 
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
               System.out.println(username + ": " + inputLine);
               broadcast(username + ": " + inputLine);
            }
 
            System.out.println("User disconnected: " + username);
            broadcast(username + " has left the chat.");
            chatThreads.remove(this);
            in.close();
            out.close();
            clientSocket.close();
 
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
 
      public void sendMessage(String message) {
         // 给他们的socket发送
         out.println(message);
      }
   }
}


