package AlgorithmsAndDatastructures.DataStructures;

public class StackList {
    private LinkedList list;

    public StackList(){
        list = new LinkedList();
    }

    public void push(String name, int age){
        list.insert(name, age);
    }

    public String pop(){
        return list.delete().name;
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void display(){
        list.display();
    }
}

class StackListTest {
    public static void main(String[] args) {
        StackList sl = new StackList();
        sl.push("Artem", 30);
        sl.push("Viktor", 20);
        sl.push("Sergey", 10);
        sl.display();

        while (!sl.isEmpty()) {
            System.out.println("Элемент " + sl.pop() + " удален из стека");
        }
    }
}
