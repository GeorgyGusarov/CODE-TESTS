package AlgorithmsAndDatastructures.DataStructures;

import java.util.Objects;

public class HashTable {
    private static class Item {
        int data;

        public Item(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Item item = (Item) o;
            return data == item.data;
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }
    }

    private Item[] hashArray;
    private int arrSize;

    public HashTable(int capacity) {
        this.hashArray = new Item[capacity];
        this.arrSize = capacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrSize; i++) {
            sb.append((hashArray[i] != null) ? hashArray[i].getData() : "*");
            if (i < arrSize - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    private int hashFunc(int key) {
        return key % arrSize;
    }


    /**
     * поиск элемента
     */
    public Item find(int key) {
        int hashVal = hashFunc(key); // находим хэш ключа при помощи функции и кладем его в Val
        while (hashArray[hashVal] != null) { // если ячейка массива не пуста
            if (hashArray[hashVal].getData() == key) { // содержит ли она искомый ключ
                return hashArray[hashVal]; // если да, то возвращаем значение
            }
            ++hashVal; // если не нашли, перемещаемся на следующее значение
            hashVal %= arrSize;
        }
        return null;
    }
}
