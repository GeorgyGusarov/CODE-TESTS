package AlgorithmsAndDatastructures.DataStructures;

public class DequeueTest extends QueueTest {
    public DequeueTest(int size) {
        super(size);
    }

    // методы добавления элементов в голову и хвост очереди
    public void enqueueTail(int i) {
        super.insert(i);
    }

    public void enqueueHead(int i) {
        if (isFull()) throw new RuntimeException("Dequeue is full!");
        if (getHead() == 0) setHead(getSize());

        getQueue()[getHead() - 1] = i;
        setHead(getHead() - 1);
        setItems(getItems() + 1);
    }

    // методы удаления элементов из головы и хвоста очереди
    public int dequeueTail() {
        if (isEmpty()) throw new RuntimeException("Dequeue is full!");

        int temp = getQueue()[getTail()];
        setTail(getTail() + 1);
        if (getTail() == getSize()) setTail(0);
        setItems(getItems() - 1);
        return temp;
    }

    public int dequeueHead() {
        return super.remove();
    }
}
