package Geekbrains_Java2.Lesson_6;

import java.io.*;
import java.net.*;
import java.util.*;

public class ServerMain {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен");

            socket = server.accept();
            System.out.println("Клиент подключился");

            Scanner scanner = new Scanner(socket.getInputStream()); // с помощью сканера читаем данные из сети

            /**
             * Realization of echo server
             */
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                String str = scanner.nextLine();
                System.out.println("Client: " + str);

                if (str.equals("/end")) {
                    break;
                }

                System.out.println("echo " + str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
