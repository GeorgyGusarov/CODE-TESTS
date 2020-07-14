package Other;

public class DuckOverload { // перегруженый Duck
    int size;

    public DuckOverload(int duckSize) { // конструктор
        this.size = duckSize;
    }

    public DuckOverload() { // конструктор
        size = 27;
    }
}

class DuckOverloadUse {

    public static void main(String[] args) {
        DuckOverload d = new DuckOverload(15);
        DuckOverload d2 = new DuckOverload();
    }
}
