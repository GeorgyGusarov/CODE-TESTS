package Other;

public class StaticSuper {

    static {
        System.out.println("Родительский статический блок");
    }

    public StaticSuper() {
        System.out.println("Родительский конструктор");
    }
}

class StaticTest extends StaticSuper {
    static int rand;

    static {
        rand = (int) (Math.random() * 6);
        System.out.println("Статический блок " + rand);
    }

    public StaticTest() {
        System.out.println("Конструктор");
    }

    public static void main(String[] args) {
        System.out.println("Внутри main");
        StaticTest st = new StaticTest();
    }
}
