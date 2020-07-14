package Other;

public class MethodMath {
    public static void main(String[] args) {
        double r1 = Math.random();
        int r2 = (int) (Math.random() * 5);
        System.out.println(r1 + " / " + r2);

        int x = Math.abs(-240);
        double d = Math.abs(240.45);
        System.out.println(x + " / " + d);

        int y = Math.round(-24.8f);
        double i = Math.round(24.45);
        System.out.println(y + " / " + i);

        int m = Math.min(24, 240);
        double dm = Math.min(90876.5, 90876.49);
        System.out.println(m + " / " + dm);

        int q = Math.max(24, 240);
        double w = Math.max(90876.5, 90876.49);
        System.out.println(q + " / " + w);
    }
}
