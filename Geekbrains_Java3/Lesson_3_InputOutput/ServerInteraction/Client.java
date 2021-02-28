package Geekbrains_Java3.Lesson_3_InputOutput.ServerInteraction;

import java.io.*;
import java.net.*;

public class Client {
    public Client(String host, int port, String file) {
        try {
            socket = new Socket(host, port);
            sendFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Students student = new Students(1, "Bob");

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Lesson_3_test/students2.ser"));
            oos.writeObject(student);
            oos.close();

            String filePath = "Lesson_3_test/students2.ser";
            new Client("localhost", 1995, filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Socket socket;

    public void sendFile(String file) {
        try {
            FileInputStream in = new FileInputStream(file);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            byte[] buffer = new byte[4096];
            while (in.read(buffer) > 0) {
                out.write(buffer);
            }

            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
