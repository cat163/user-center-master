package com.whq.usercenter.once.imageSocket;

import java.io.*;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8080);
            InputStream is = socket.getInputStream();
            FileOutputStream fos = new FileOutputStream("received.jpg");
            byte[] buffer = new byte[4096];

            while (is.read(buffer) > 0) {
                fos.write(buffer);
            }

            fos.close();
            is.close();
            socket.close();
            System.out.println("Image received.");

            // 在聊天室界面上显示接收到的图片
            // TODO: 实现聊天室界面的代码

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
