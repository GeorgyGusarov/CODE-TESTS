package AlgorithmsAndDatastructures.Recursion;

public class Test4 {
    public static void main(String[] args) {
        rec(5);
    }

    static void rec(int i) {
        if (i == 0) {
            return;
        } else {
            System.out.println(i);
            rec(i - 1);
        }
    }
}
