package LambdaExamples;

public class LambdaExample {
    public static void main(String[] args) {

        LambdaOperation lambdaOperation;
        lambdaOperation = (x, y) -> x + y;

        int result = lambdaOperation.calculate(20, 10);
        System.out.println(result);

/**
 * то же самое, что и выше, но не лямбдой
 */
//        LambdaOperation lambdaOperation = new LambdaOperation() {
//            @Override
//            public int calculate(int x, int y) {
//                return x + y;
//            }
//        };
//
//        int z = lambdaOperation.calculate(20, 10);
//        System.out.println(z);
    }
}

interface LambdaOperation {
    int calculate(int x, int y);
}
