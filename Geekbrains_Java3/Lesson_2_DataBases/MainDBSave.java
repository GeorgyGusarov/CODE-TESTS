package Geekbrains_Java3.Lesson_2_DataBases;

import java.sql.*;

public class MainDBSave {

    private static Connection connection; // соединение с базой
    private static Statement statement; // передача запроса в базу

    public static void main(String[] args) {
        try {
            connect();

            statement.executeUpdate("INSERT INTO students (name, score) VALUES ('BodUnique1', 10)");
            Savepoint savepoint = connection.setSavepoint();
            statement.executeUpdate("INSERT INTO students (name, score) VALUES ('BodUnique2', 20)");
            connection.rollback(savepoint);
            connection.setAutoCommit(true);
            statement.executeUpdate("INSERT INTO students (name, score) VALUES ('BodUnique3', 30)");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
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