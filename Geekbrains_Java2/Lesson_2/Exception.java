package Geekbrains_Java2.Lesson_2;

public class Exception {
    public static void main(String[] args) {

        int a, b;

        try {
            int[] res = {1, 2, 3};
            b = 10 / 0;
            res[10] = 20;
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("Делить на ноль нельзя!");
        } catch (ArrayIndexOutOfBoundsException ex) {
            ex.printStackTrace();
            System.out.println("Вышли за пределы массива!");
        } finally {
            System.out.println("выполнится");
        }
        System.out.println("end");
    }
}
