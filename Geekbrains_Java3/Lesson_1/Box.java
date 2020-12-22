package Geekbrains_Java3.Lesson_1;

public class Box {
    private Object obj;

    public Box(Object obj) {
        this.obj = obj;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public void info() {
        System.out.println("obj " + obj);
        System.out.println("type " + obj.getClass() + "\n");
    }
}

class BoxMain {
    public static void main(String[] args) {
        Box box1 = new Box(1);
        Box box2 = new Box("str");

        box1.info();
        box2.info();

        int x = 10;
        x = x + (Integer) box1.getObj();
        System.out.println("x = " + x);

        x = x + (Integer) box2.getObj();
        System.out.println("x = " + x);
    }
}
