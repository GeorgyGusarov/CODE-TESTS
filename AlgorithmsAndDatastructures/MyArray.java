package AlgorithmsAndDatastructures;

public class MyArray {
    private int[] arr;
    private int size;

    public MyArray(int capacity) {
        arr = new int[capacity];
        this.size = 0;
    }

    public MyArray(int... args) {
        this.size = args.length;
        this.arr = args;
    }

    /**
     * getter
     */
    public int get(int index) {
        if (index >= size || index < 0) throw new ArrayIndexOutOfBoundsException(index);
        return arr[index];
    }

    /**
     * setter
     */
    public void set(int index, int value) {
        if (index >= size || index < 0) throw new ArrayIndexOutOfBoundsException(index);
        arr[index] = value;
    }

    /**
     * custom method witch returns arrays length
     */
    public int length() {
        return size;
    }

    /**
     * increases array's capacity
     */
    private void increaseCapacity() {
        int[] temp = arr;   // temporary array
        arr = new int[size * 2];
        System.arraycopy(temp, 0, arr, 0, size);
    }

    /**
     * adds an index to the end of an array
     */
    public void append(int value) {
        if (size >= arr.length) increaseCapacity();
        arr[size++] = value;
    }

    /**
     *
     */
    public void insert() {

    }

    public int deleteLast() {
        if (size == 0) throw new ArrayIndexOutOfBoundsException(-1);
        return arr[--size]; // сначала уменьшаем, а потом получаем size
    }

    /**
     * simple linear search
     * @param value - value to find
     * @return the value
     */
    private int find(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) return i;
        }
        return -1;
    }

    /**
     * custom toString method (structure copied from original method)
     */
    @Override
    public String toString() {
        if (arr == null) {
            return "null";
        }

        int iMax = size - 1;
        if (iMax == -1) {
            return "[]";
        }

        StringBuilder b = new StringBuilder();
        b.append('[');
        int i = 0;
        while (true) {
            b.append(arr[i]);
            if (i == iMax) {
                return b.append(']').toString();
            }
            b.append(", ");
            i++;
        }
    }
}

class MyArrayTest {
    public static void main(String[] args) {
        CustomArray a0 = new CustomArray(1, 2, 3, 4, 5);
        System.out.println(a0);
    }
}
