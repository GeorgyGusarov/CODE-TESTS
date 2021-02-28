package Geekbrains_Java3.Lesson_7_ReflectionAPI_Annotations.HomeworkCheck;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.HashMap;

public class StudentsTest {
    static Connection connection;
    static Statement statement;

    public static void main(String[] args) throws SQLException {
        prepareTable(Students.class); // создание таблицы
        Students s = new Students(1, "Bob", 100, "bob@gmail.com");
        addObject(s);
    }

    public static void connect() throws Exception {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:mydb_3.db");
        statement = connection.createStatement();
    }

    public static void disconnect() throws SQLException {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void prepareTable(Class c) throws SQLException {
        if (!c.isAnnotationPresent(XTable.class)) throw new RuntimeException("XTable annotation is missed!");

        // если у нас есть поле int то напишем его как INTEGER и т.д.
        HashMap<Class, String> hm = new HashMap<>(); // мапа нужна для проверки соответствия (int = INTEGER) и т.д.
        hm.put(int.class, "INTEGER");
        hm.put(String.class, "TEXT");

        try {
            connect();
            // узнаем имя таблицы
            String tableName = ((XTable) c.getAnnotation(XTable.class)).name();
            // если такая таблица есть то дропнем ее
            statement.executeUpdate("DROP TABLE IF EXISTS " + tableName + ";");
            // создадим таблицу, но мы не можем сразу собрать запрос, поэтому соберем по кускам
            String query = "CREATE TABLE IF NOT EXISTS " + tableName + " (";
            // получаем все поля из класса
            Field[] fields = c.getDeclaredFields();
            for (Field o : fields) {
                // если есть аннотация, то дабавляем ее в таблицу
                if (o.isAnnotationPresent(XField.class)) query += o.getName() + " " + hm.get(o.getType()) + ", ";
            }
            query = query.substring(0, query.length() - 2);
            query += ");";
            statement.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public static void addObject(Object obj) throws SQLException {
        Class c = obj.getClass();
        if (!c.isAnnotationPresent(XTable.class)) throw new RuntimeException("XTable annotation is missed!");
        try {
            connect();
            String tableName = ((XTable) c.getAnnotation(XTable.class)).name();
            String query = "INSERT INTO " + tableName + " (";
            Field[] fields = c.getDeclaredFields();

            for (Field o : fields) {
                if (o.isAnnotationPresent(XField.class)) query += o.getName() + ", ";
            }
            query = query.substring(0, query.length() - 2);
            query += ") VALUES (";

            for (Field o : fields) {
                if (o.isAnnotationPresent(XField.class)) query += "?, ";
            }
            query = query.substring(0, query.length() - 2);
            query += ");";

            PreparedStatement ps = connection.prepareStatement(query);
            int counter = 1;
            for (Field o : fields) {
                if (o.isAnnotationPresent(XField.class)) {
                    ps.setObject(counter, o.get(obj));
                    counter++;
                }
            }
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }
}
