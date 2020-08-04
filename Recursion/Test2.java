package Recursion;

public class Test2 {

    static int factorial(int x) {
        int result = 1;

        for (int i = 1; i <= x; i++) {
            result *= i;
        }

        return  result;
    }

}
