package Geekbrains_Java2.Lesson_1;

public class Box {

    String color;
    int weight;
    String name;

    public static void main(String[] args) {
        Box box = new Box("red", 10, "test");
        Box box2 = new Box("black", 15, "test2");
        Box box3 = new Box("blue", 12);
        box.info();
        box2.info();
        box3.info();
    }

    public void info() {
        System.out.println(color + " " + weight + " " + name);
    }

    public Box(String color, int weight, String name) {
        this.color = color;
        this.weight = weight;
        this.name = name;
    }

    public Box(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }
}
