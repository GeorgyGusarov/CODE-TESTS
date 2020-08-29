package GenericsAndCollections;

import java.util.ArrayList;

public class TestGenerics1 {

    public static void main(String[] args) {
        new TestGenerics1().go();
    }

    public void go() {
//        Animal[] animals = {new Dog(), new Cat(), new Dog()};
//        Dog[] dogs = {new Dog(), new Dog(), new Dog()};
//        Cat[] cats = {new Cat(), new Cat(), new Cat()};
//
//        takeAnimals(animals);
//        takeAnimals(dogs);
//        takeAnimals(cats);

        ArrayList<Animal> animals = new ArrayList<Animal>();

        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(new Dog());

        takeAnimals(animals);

    }

//    public void takeAnimals(Animal[] animals) {
//        for (Animal a : animals) {
//            a.eat();
//        }
//    }

    public void takeAnimals(ArrayList<? extends Animal> animals) {
        for (Animal a : animals) {
            a.eat();
        }
    }
}

abstract class Animal {
    void eat() {
        System.out.println("животное ест " + getClass());
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("гав");
    }
}

class Cat extends Animal {
    void meow() {
        System.out.println("мяу");
    }
}


