package Other;

import static java.lang.System.out;
import static java.lang.Math.*;

public class StaticImport {
    public static void main(String[] args) {
        System.out.println("sqrt" + Math.sqrt(2.0));
        System.out.println("tan" + Math.tan(60));
    }
}

class WithStatic {
    public static void main(String[] args) {
        out.println("sqrt" + sqrt(2.0));
        out.println("tan" + tan(60));
    }
}
