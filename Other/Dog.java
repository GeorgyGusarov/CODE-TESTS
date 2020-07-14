package Other;

class Dog {
    protected int size;
    protected String name;

    public static void main(String[] args) {
        // создаем объект Other.Dog и получаем к нему доступ
        Dog dog1 = new Dog();
        dog1.name = "Барт";
        dog1.bark();

        // теперь создадим массив типа Other.Dog
        Dog[] myDogs = new Dog[3];
        // и поместим в него несколько элементов
        myDogs[0] = new Dog();
        myDogs[1] = new Dog();
        myDogs[2] = dog1;

        // теперь получем доступ к объектам Other.Dog
        // с помощью ссылок из массива
        myDogs[0].name = "Фред";
        myDogs[1].name = "Джордж";

        // какое имя у myDogs[2]?
        System.out.println("Имя последней собаки - ");
        System.out.println(myDogs[2].name);

        // теперь переберем все элементы массива
        // и вызовем для каждого метод bark()
        int x = 0;
        while (x < myDogs.length) {
            myDogs[x].bark();
            x++;
        }
    }

    public void bark() {
        System.out.println(name + " сказал Гав!");
    }
}