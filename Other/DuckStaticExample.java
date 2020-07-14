package Other;

public class DuckStaticExample {
    private static int size = 3;
    private static int duckCount = 0;

    public static void main(String[] args) {
        System.out.println("Размер утки равен " + size + ", а всего уток " + duckCount);    // size доступен, потому что он static как и main метод

        DuckStaticExample duck = new DuckStaticExample();
        System.out.println("создали утку номер " + duckCount);  // конструктором сделали 1 утку (duckCount++)

        DuckStaticExample.duckCount = 5;
        System.out.println("а теперь уток " + DuckStaticExample.duckCount);
    }

    public static int getSize() {
        return size;
    }

    public static void setSize(int size) {
        DuckStaticExample.size = size;
    }

    public DuckStaticExample() {
        duckCount++;
    }
}
