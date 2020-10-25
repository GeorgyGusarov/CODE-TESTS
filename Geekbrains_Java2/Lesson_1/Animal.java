package Geekbrains_Java2.Lesson_1;

public class Animal {
    private int a;
    protected int z;

    public Animal(int a, int z) {
        this.a = a;
        this.z = z;
    }

    void info() {
        System.out.println("Animal");
    }
}

class Cat extends Animal {
    protected int y;

    public Cat(int a, int z, int y) {
        super(a, z);
        this.y = y;
    }

    @Override
    void info() {
        // super.info(); - так можно обратиться к родительскому свойству, т.е. к методу info() Animal
        System.out.println("Cat");
    }
}

class SuperCat extends Cat {
    int u;

    public SuperCat(int a, int z, int y, int u) {
        super(a, z, y);
        this.u = u;
    }

    @Override
    void info() {
        System.out.println("Super Cat");
    }
}

class TestAnimal {
    public static void main(String[] args) {
//        SuperCat superCat = new SuperCat(1, 2, 3, 4);
//        superCat.info();

        Animal[] animals = {new Animal(1, 2), new Cat(1, 2, 3), new SuperCat(1, 2, 3, 4)};

        for (Animal animal : animals) {
            animal.info();
        }
    }
}
