package Geekbrains_Java3.Lesson_1_Generics;

public class BoxGeneric<T> {
    private T obj;

    public BoxGeneric(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public void info() {
        System.out.println("obj " + obj);
        System.out.println("type " + obj.getClass() + "\n");
    }
}

class BoxGenericMain {
    public static void main(String[] args) {
        BoxGeneric<Integer> box1 = new BoxGeneric<>(1);
        BoxGeneric<String> box2 = new BoxGeneric<>("str");

        box1.info();
        box2.info();

        int x = 10;
        x = x + box1.getObj();
        System.out.println("x = " + x);
    }
}
