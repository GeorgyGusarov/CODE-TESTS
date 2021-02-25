package Geekbrains_Java3.Lesson_2_DataBases;

import java.sql.*;

public class MainDBPrepStat {

    private static Connection connection; // соединение с базой
    private static Statement statement; // передача запроса в базу
    private static ResultSet resultSet; // результат запроса Statement
    private static ResultSetMetaData resultSetMetaData; // мета данные о таблице (тип столбцов, название столбцов и тд.)
    private static PreparedStatement preparedStatement;

    public static void main(String[] args) {
        try {
            connect();

            long time = System.currentTimeMillis();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("INSERT INTO students (name, score) VALUES (?, ?)");
            for (int i = 0; i < 1000; i++) {
                preparedStatement.setString(1, "Bob" + i);
                preparedStatement.setInt(2, 10 * (i + 1));
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            connection.setAutoCommit(true);
            System.out.println(System.currentTimeMillis() - time + " milliseconds");

            resultSet = statement.executeQuery("SELECT * FROM students");
            resultSetMetaData = resultSet.getMetaData();
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                System.out.println("Column name: " + resultSetMetaData.getColumnName(i) + " " + "Table name: " +  resultSetMetaData.getTableName(i));
            }
            while (resultSet.next()) { // спрашиваем: есть ли данные в строке таблицы? Если true, то начинаем выполнять действия из тела цикла
                System.out.println("id: " + resultSet.getInt(1) + " name: " + resultSet.getString("name") + " score: " + resultSet.getInt("score"));
            }
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
