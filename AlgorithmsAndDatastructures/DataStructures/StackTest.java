package AlgorithmsAndDatastructures.DataStructures;

import java.util.NoSuchElementException;

public class StackTest {
    private int[] stack;
    private int capacity;
    private int head;   // указатель не текущий рабочий элемент стэка. Его конец и будет являтся вершиной.

    public StackTest(int capacity) {
        this.stack = new int[capacity];
        this.capacity = capacity;
        this.head = -1; //  флаг пустого стэка, 0 - это первый элемент. Если сделаем head = 0, значит в "голове" стэка уже что-то есть
    }

    public boolean isEmpty() {
        return this.head == -1;
    }

    public boolean isFull() {
        return this.capacity == this.head + 1;
    }

    /**
     * adds an element to stack
     */
    public void push(int value) {   // like append()
        if (isFull()) {
            capacity *= 2; // x2
            int[] newStack = new int[capacity];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
        stack[++head] = value;
    }

    /**
     * return an element from stack
     */
    public int pop() { // like deleteLast()
        if (isEmpty()) throw new NoSuchElementException("Stack is empty!");
        return stack[head--];
    }

    /**
     * check current element
     */
    public int peek() {
        return stack[head];
    }

    @Override
    public String toString() {
        if (stack == null) {
            return "null";
        }

        int iMax = capacity - 1;
        if (iMax == -1) {
            return "[]";
        }

        StringBuilder b = new StringBuilder();
        b.append('[');
        int i = 0;
        while (true) {
            b.append(stack[i]);
            if (i == iMax) {
                return b.append(']').toString();
            }
            b.append(", ");
            i++;
        }
    }
}

class StackMain {
    public static void main(String[] args) {
        StackTest stack = new StackTest(10);
        stack.isEmpty();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);

        System.out.println(stack.isFull());
        System.out.println(stack.peek());
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }
}
