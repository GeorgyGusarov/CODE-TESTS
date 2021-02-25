package Geekbrains_Java3.Lesson_1_Generics;

public class LambdaExample2 {

    public static void main(String[] args) {
        LambdaOperation2 sum = (x, y) -> x + y;

        LambdaOperation2 sub = (x, y) -> x - y;

        LambdaOperation2 multip = (x, y) -> x * y;

        LambdaOperation2 div = (x, y) -> {
            try {
                return x/y;
            } catch (ArithmeticException e) {
                e.printStackTrace();
                System.out.println("Нельзя делить на ноль!");
            }
            return -1;
        };

        double result = sum.calculate(10, 20);
        System.out.println("10 + 20 = " + result);

        result = sub.calculate(10, 20);
        System.out.println("10 - 20 = " + result);

        result = multip.calculate(10, 20);
        System.out.println("10 * 20 = " + result);

        result = div.calculate(10, 20);
        System.out.println("10 / 20 = " + result);
    }
}

interface LambdaOperation2 {
    double calculate(double x, double y);
}
