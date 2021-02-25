package Geekbrains_Java2.Lesson_1_OOP;

public class User {
    private int id;
    private String name;
    private String position;
    private int age;

    // параметизированный конструктор
    public User(int id, String name, String position, int age) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.age = age;
    }

    public void info() {
        System.out.println("id: " + id + "; Имя пользователя: " + name + "; Должность: " + position + "; Возраст: " + age);
    }

    public void changeUserPosition(String newPosition) {
        this.position = newPosition;
        System.out.println("Пользователь: " + name + " получил новую должность: " + position);
    }
}

class UserMain {
    public static void main(String[] args) {
        User user1 = new User(1, "Jake", "Senior Programmer", 35);
        User user2 = new User(2, "Paul", "Team Lead", 25);
        User user3 = new User(3, "Tiffany", "Junior Programmer", 31);
        User user4 = new User(4, "Sam", "unemployed", 18);

        user1.info();
        user2.info();
        user3.info();
        user4.info();

        user4.changeUserPosition("Junior Software Engineer");
    }
}
