package Other;

public abstract class Animal2 {
    private String name;

    public String getName() {   // Hippo2 наследует этот геттер
        return name;
    }

    public Animal2(String theName) {
        this.name = theName;
    }
}

class Hippo2 extends Animal2 {

    public Hippo2(String name) {
        super(name);    // через super вызываем конструктор Animal и передаем ему name
    }
}

class MakeHippo {
    public static void main(String[] args) {
        Hippo2 h2 = new Hippo2("Баффи");
        System.out.println(h2.getName());
    }
}
