package Recursion;

public class Test1 {

    static int factorial(int x) {

        if (x == 1) {
            return 1;
        }

        return x * factorial(x - 1);
    }
}
