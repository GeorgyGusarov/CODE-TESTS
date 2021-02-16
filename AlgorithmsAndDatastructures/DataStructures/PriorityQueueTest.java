package AlgorithmsAndDatastructures.DataStructures;

public class PriorityQueueTest extends QueueTest {
    public PriorityQueueTest(int size) {
        super(size);
    }

    @Override
    public void insert(int newValue) {  // O(n)
        if (isFull()) throw new RuntimeException("Queue is full!");

        // линейный поиск
        int i;
        for (i = 0; i < getSize(); i++) {
            // ищем место, где текущий принятый приоритет будет меньше чем то, что лежит внутри массива
            if (getQueue()[i] > newValue) break;
        }

        // смешаем все элементы вправо освобождая одно свободное место
        System.arraycopy(getQueue(), i, getQueue(), i + 1, getSize() - i);
        // и кидаем в одно свободное место значение
        getQueue()[i] = newValue;
        setSize(getSize() + 1);
    }

    @Override
    public int remove() {   //O(1)
        if (isEmpty()) throw new RuntimeException("Queue is empty!");

        int temp = getQueue()[0]; // remove с нулевого индекса
        // смещаем массив в сторону нулевого индекса
        System.arraycopy(getQueue(), 1, getQueue(), 0, getSize());
        setSize(getSize() - 1);
        return temp;
    }
}
