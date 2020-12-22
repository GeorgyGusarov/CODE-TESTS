package Geekbrains_Java3.Lesson_1;

public class BoxTwoTypes<T, V> {
    private T obj1;
    private V obj2;

    public BoxTwoTypes(T obj1, V obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public T getObj1() {
        return obj1;
    }

    public V getObj2() {
        return obj2;
    }

    public void setObj1(T obj1) {
        this.obj1 = obj1;
    }

    public void setObj2(V obj2) {
        this.obj2 = obj2;
    }

    public void info() {
        System.out.println("Type of T: " + obj1.getClass().getName());
        System.out.println("Type of V: " + obj2.getClass().getName());
    }
}

class BoxTwoTypesMain {
    public static void main(String[] args) {
        BoxTwoTypes<Integer, String> boxTwoTypes = new BoxTwoTypes<>(555, "Hello");
        boxTwoTypes.info();
    }
}
