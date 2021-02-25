package Geekbrains_Java3.Lesson_2_DataBases;

import java.sql.*;

public class MainDB {

    private static Connection connection; // соединение с базой
    private static Statement statement; // передача запроса в базу
    private static ResultSet resultSet; // результат запроса Statement
    private static ResultSetMetaData resultSetMetaData; // мета данные о таблице (тип столбцов, название столбцов и тд.)

    public static void main(String[] args) {
        try {
            connect();

            resultSet = statement.executeQuery("SELECT * FROM students");
            resultSetMetaData = resultSet.getMetaData();
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                System.out.println(resultSetMetaData.getColumnName(i) + " " + resultSetMetaData.getTableName(i));
            }
            while (resultSet.next()) { // спрашиваем: есть ли данные в строке таблицы? Если true, то начинаем выполнять действия из тела цикла
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString("name") + " " + resultSet.getInt("score"));
            }

            connection.setAutoCommit(false);
            long time = System.currentTimeMillis();
            for (int i = 0; i < 1000; i++) {
                statement.executeUpdate("INSERT INTO students (name, score) VALUES ('unknown', " + i * 10 + ")");
            }
            connection.setAutoCommit(true);
            System.out.println(System.currentTimeMillis() - time);
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
