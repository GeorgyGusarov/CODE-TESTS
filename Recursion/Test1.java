package Recursion;

public class Test1 {
    public static void main(String[] args) {
        factorial(10);
    }

    static int factorial(int x) {
        if (x == 1) {
            return 1;
        }
        System.out.println(x);
        return x * factorial(x - 1);
    }
}
