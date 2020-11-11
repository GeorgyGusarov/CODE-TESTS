package Recursion;

public class Test2 {
    public static void main(String[] args) {
        factorial(5);
    }

    static int factorial(int x) {
        int result = 1;

        for (int i = 1; i <= x; i++) {
            result *= i;
        }
        System.out.println(x);
        return result;
    }

}
