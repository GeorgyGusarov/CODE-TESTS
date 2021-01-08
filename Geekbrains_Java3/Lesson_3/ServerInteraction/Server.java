package Geekbrains_Java3.Lesson_3.ServerInteraction;

import java.io.*;
import java.net.*;

public class Server extends Thread {
    private ServerSocket serverSocket;

    public Server(int port) {
        try {
            serverSocket = new ServerSocket(port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server(1995);
        server.start();
    }

    public void run() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();

                try {
                    saveFile(clientSocket);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveFile(Socket clientSocket) throws IOException, ClassNotFoundException {
        DataInputStream din = new DataInputStream(clientSocket.getInputStream());
        FileOutputStream fos = new FileOutputStream("Lesson_3_test/students2.ser");

        byte[] buffer = new byte[4096];
        int fileSize = 151123;
        int read = 0;
        int totalRead = 0;
        int alreadyRead = fileSize;

        while ((read = din.read(buffer, 0, Math.min(buffer.length, alreadyRead))) > 0) {
            totalRead += read;
            alreadyRead -= read;
            System.out.println("read: " + totalRead + " bytes.");
            fos.write(buffer,0, read);
        }

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Lesson_3_test/students2.ser"));
        Students student = (Students) in.readObject();
        in.close();
        student.info();
        fos.close();
    }
}
