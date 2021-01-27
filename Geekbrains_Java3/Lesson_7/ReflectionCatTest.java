package Geekbrains_Java3.Lesson_7;

public class ReflectionCatTest {
    String name;
    public String color;
    private int age;

    public ReflectionCatTest(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @MyAnnotation(priority = 5)
    public void info1() {
        System.out.println("info1: " + name + " " + color + " " + age);
    }

    private void info2() {
        System.out.println("info2: " + name + " " + color + " " + age);
    }
}
