package Geekbrains_Java2.Lesson_1_OOP;

public class ExampleOfThis {
    public static void main(String[] args) {
        Cat2 cat2 = new Cat2("cat2");
        Cat2 cat3 = new Cat2("cat3");
        Cat2[] catsArray = new Cat2[2];

        cat2.putMeInArray(catsArray, 0);
        cat3.putMeInArray(catsArray, 1);

        for (Cat2 o : catsArray) {
            System.out.println(o.toString());
        }
    }
}

class Cat2 {
    private String name;

    public Cat2(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat: " + name;
    }

    public void putMeInArray(Cat2[] arrayOfCats, int arrayIndex) {
        arrayOfCats[arrayIndex] = this;
    }
}
