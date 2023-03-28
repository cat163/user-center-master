package com.whq.usercenter.once.imageSocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ImageServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            List<Socket> clients = new ArrayList<>();
            System.out.println("Server started.");

            while (true) {
                Socket socket = serverSocket.accept();
                InputStream is = socket.getInputStream();
                FileOutputStream fos = new FileOutputStream("received.jpg");
                byte[] buffer = new byte[4096];

                while (is.read(buffer) > 0) {
                    fos.write(buffer);
                }

                fos.close();
                is.close();
                socket.close();
                System.out.println("Image received and saved.");

                // 广播图片给所有客户端
                for (Socket client : clients) {
                    OutputStream os = client.getOutputStream();
                    DataOutputStream dos = new DataOutputStream(os);
                    FileInputStream fis = new FileInputStream("received.jpg");

                    buffer = new byte[4096];
                    while (fis.read(buffer) > 0) {
                        dos.write(buffer);
                    }

                    fis.close();
                    dos.close();
                    os.close();
                    System.out.println("Image broadcasted to client.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
