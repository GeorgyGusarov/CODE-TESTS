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

    @Override
    public String toString() {
        if (queue == null) {
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
            b.append(queue[i]);
            if (i == iMax) {
                return b.append(']').toString();
            }
            b.append(", ");
            i++;
        }
    }
}

class QueueTestMain {
    public static void main(String[] args) {
        QueueTest queue = new QueueTest(10);
        System.out.println(queue.isEmpty());
        System.out.println(queue);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        queue.insert(6);
        queue.insert(7);
        queue.insert(8);
        queue.insert(9);
        queue.insert(10);
        System.out.println(queue);
        System.out.println("items: " + queue.getItems());
        System.out.println("size: " + queue.getSize());
        System.out.println("head: " + queue.getHead());
        System.out.println("tail: " + queue.getTail());
        queue.setTail(77);
        queue.setHead(77);
        System.out.println("head: " + queue.getHead());
        System.out.println("tail: " + queue.getTail());
        System.out.println(queue);
    }
}
