package Geekbrains_Java2.Lesson_1;

public class TestClass { // объект
    int b = 10;  // поле объекта
    String s;   // поле объекта

    public static void main(String[] args) {
        sum(4, 5);
        abc();

    }

    static void abc() {
        System.out.println("abc");
    }

//    public static void sum(int a, int b) {
//        System.out.println(a + b);
//    }

    // пример аргумента переменной длинны
    public static void sum(int... a) {
        int result = 0;

        for (int i = 0; i < a.length; i++) {
            result += a[i];
        }
        System.out.println(result);
    }
}
