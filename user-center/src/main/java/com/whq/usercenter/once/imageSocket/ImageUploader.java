package com.whq.usercenter.once.imageSocket;


import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.Socket;

public class ImageUploader {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8080);
            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            FileInputStream fis = new FileInputStream("image.jpg");
            byte[] buffer = new byte[4096];

            while (fis.read(buffer) > 0) {
                dos.write(buffer);
            }

            fis.close();
            dos.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
