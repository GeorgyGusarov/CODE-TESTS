package Other;

public class Animal {

    public Animal() {
        System.out.println("Создание Animal");
    }
}

class Hippo extends Animal {

    public Hippo() {
        System.out.println("Создание Hippo");
    }
}

class Duck2 extends Animal {
    int size;

    public Duck2(int newSize) {
        super();    // компилятор добавляет super автоматом, его можно не писать
        System.out.println("Создание Duck " + newSize);
        this.size = newSize;
    }
}

class TestHippo {
    public static void main(String[] args) {
        System.out.println("Начало...");
        Hippo h = new Hippo();  // сначала сработает конструктор Animal, так как Hippo при создании (new) вызывает родительский конструктор
        Duck2 d2 = new Duck2(12);
    }
}
