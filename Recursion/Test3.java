package Recursion;

public class Test3 {

    static int fibonachi(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }
        else{
            return fibonachi(n - 1) + fibonachi(n - 2);
        }
    }

}
