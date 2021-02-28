package AlgorithmsAndDatastructures.Recursion;

public class fibonacci {
    public static void main(String[] args) {
        fibonacci(5);
    }

    static int fibonacci(int n) {
        System.out.println(n);
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
