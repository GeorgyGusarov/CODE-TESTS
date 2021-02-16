package AlgorithmsAndDatastructures.DataStructures;

import java.util.NoSuchElementException;

public class QueueTest {
    private int[] queue;
    private int capacity;
    private int head;   // место, из которого элементы уходят
    private int tail;   // место, в который элеемнты приходят
    private int items;  // текущее количество элементов в очереди

    public QueueTest(int capacity) {
        this.queue = new int[capacity];
        this.capacity = capacity;
        this.head = 0;
        this.tail = -1;
        this.items = 0;
    }

    public boolean isEmpty() {
        return this.items == 0;
    }

    public boolean isFull() {
        return this.items == this.capacity;
    }

    public int size() {
        return items;
    }

    /**
     * динамическое расширение очереди
     */
    public void insert(int value) {
        if (isFull()) {
            capacity *= 2;  // x2
            int[] newQueue = new int[capacity];
            if (tail >= head) {
                System.arraycopy(queue, 0, newQueue, 0, queue.length);
            } else {
                System.arraycopy(queue, 0, newQueue, 0, tail + 1);
                System.arraycopy(queue, head, newQueue, capacity - (queue.length - head), queue.length - head - 1);
            }
            queue = newQueue;
        }
        if (tail == capacity - 1) tail = -1;
        queue[++tail] = value;
        items++;
    }

    public int remove() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty!");
        int temp = queue[head++];
        head %= capacity;   // if (head == capacity) head = 0
        items--;
        return temp;
    }

    public int peek() {
        return queue[head++];
    }

    public int getSize() {
        return capacity;
    }

    public void setSize(int size) {
        this.capacity = size;
    }

    public int[] getQueue() {
        return queue;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }
}
