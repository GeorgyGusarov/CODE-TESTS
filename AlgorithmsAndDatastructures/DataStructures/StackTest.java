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
    public int pop( ) { // like deleteLast()
        if (isEmpty()) throw new NoSuchElementException("Stack is empty!");
        return stack[head--];
    }

    /**
     * check current element
     */
    public int peek() {
        return stack[head];
    }
}
