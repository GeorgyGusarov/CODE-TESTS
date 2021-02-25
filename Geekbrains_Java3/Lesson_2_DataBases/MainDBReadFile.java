package Geekbrains_Java3.Lesson_2_DataBases;

import java.io.*;
import java.sql.*;
import java.util.*;

public class MainDBReadFile {

    private static Connection connection; // соединение с базой
    private static Statement statement; // передача запроса в базу

    public static void main(String[] args) {
        try {
            connect();
            readFile();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public static void readFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Programming\\CODE TESTS\\UpdateDB.txt");
            Scanner scanner = new Scanner(fileInputStream);
            while (scanner.hasNext()) {
                String[] array = scanner.nextLine().split(" ");
                updateDB(array[0], array[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void updateDB(String id, String newValue) {
        String sql = String.format("UPDATE students SET score = %s WHERE id = %s", newValue, id);
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:mydb_2.db");
            statement = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}