package Geekbrains_Java2.Lesson_1.Abstract;

public abstract class Animal {
    abstract void run(int a, int b);
}

// не обязан реализовывать методы родителя
abstract class Cat extends Animal {
    @Override
    void run(int a, int b) {

    }
}

class SuperCat extends Cat {

}

class TestAbstractAnimal {
    public static void main(String[] args) {

    }
}
