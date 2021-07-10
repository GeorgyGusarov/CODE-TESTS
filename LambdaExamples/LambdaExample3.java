package LambdaExamples;

import java.util.concurrent.Callable;

public class LambdaExample3 {
    public static void main(String[] args) throws Exception {

        Runnable runnable = () -> {

        };
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        };

        // Func foo = (x, y) -> x + y;
        Func foo = Integer::sum;
        System.out.println(foo.getClass());

        //Callable call = () -> null;
        Callable<Integer> call = () -> {
            int a = 4, b = 7;
            return a + b;
        };
        System.out.println(call.call());
        System.out.println(call.getClass());
    }

    static interface Func {
        int foo(int a, int b);
    }
}

