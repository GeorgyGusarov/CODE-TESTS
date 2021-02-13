package AlgorithmsAndDatastructures.Sorts;

public class MyArray {
    private int[] arr;
    private int size;
    private boolean isSorted;

    private MyArray() {
        isSorted = false;
    }

    public MyArray(int capacity) {
        this();
        if (capacity == 0) capacity = 1;
        arr = new int[capacity];
        this.size = 0;
    }

    public MyArray(int... args) {
        this();
        this.size = args.length;
        this.arr = args;
    }

    /**
     * create an array from an array
     * copying constructor
     * @param from which array we're about to copy
     */
    public MyArray(MyArray from) {
        this();
        this.arr = new int[from.size];
        this.size = from.size;
        this.isSorted = false;
        for (int i = 0; i < from.size; i++) {
            arr[i] = from.get(i);
        }
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
        arr = new int[arr.length * 2];
        System.arraycopy(temp, 0, arr, 0, size);
    }

    private void checkCapacity() {
        if (size >= arr.length) increaseCapacity();
    }

    /**
     * adds an index to the end of an array
     */
    public void append(int value) {
        checkCapacity();
        arr[size++] = value;
        isSorted = false;
    }

    /**
     * adds a random index to the end of an array
     */
    public void appendRandom(int elements, int range) {
        for (int i = 0; i < elements; i++) {
            append((int) (Math.random() * range));
        }
    }

    /**
     * inserts a value by chosen index
     */
    public void insert(int index, int value) {
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        } else if (index == size) {
            append(value);
        } else {
            checkCapacity();
            copyRight(index);
            arr[index] = value;
            size++;
        }
    }

    public boolean deleteLast() {
        if (size == 0) return false;
        size--;
        return true;
    }

    public boolean deleteByIndex(int index) {
        if (index >= size || index < 0) throw new ArrayIndexOutOfBoundsException(index);
        copyLeft(index);
        size--;
        return true;
    }

    /**
     * delete all chosen values
     * @param value - value to be deleted
     * @return - flag
     */
    public boolean deleteAllByValue(int value) {
        boolean success = false;
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                deleteByIndex(i--);
                success = true;
            }
        }
        return success;
    }

    /**
     * clears array
     */
    public void deleteAll() {
        size = 0;
    }

    private void copyLeft(int index) {
        System.arraycopy(arr, index + 1, arr, index, size - index - 1);
    }

    private void copyRight(int index) {
        System.arraycopy(arr, index, arr, index + 1, size - index - 1);
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
     * personal method for bubble sort
     */
    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public int bubbleSort() {
        int count = 0;  // shows how many steps were made to sort an array
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                count++;
                if (arr[j] > arr[j + 1]) swap(j, j + 1);
            }
        }
        isSorted = true;
        return count;
    }

    public int bubbleSortImproved() {
        int count = 0;  // shows how many steps were made to sort an array
        boolean flag = false;   // если мы на одном проходе ничего не свапнули - значит уже отсортировано
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1 - i; j++) {    // не шагаем по уже отсортированной части массива
                count++;
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1);
                    flag = true;
                }
            }
            if (!flag) break;
        }
        isSorted = true;
        return count;
    }

    /**
     * сортировка чёт и нечет
     * @return
     */
    public int bubbleSortEvenOdd() {
        int count = 0;  // shows how many steps were made to sort an array
        for (int i = 0; i < size; i++) {
            for (int j = (i % 2 != 0) ? 0 : 1; j < size - 1; j += 2) {
                count++;
                if (arr[j] > arr[j + 1]) {
                    swap(arr[j], arr[j + 1]);
                }
            }
        }
        isSorted = true;
        return count;
    }

    public int selectSort() {
        int count = 0;
        int f;
        for (int i = 0; i < size; i++) {
            f = 1;
            for (int j = i + 1; j < size; j++) {
                count++;
                if (arr[j] < arr[f]) f = j;
            }
            swap(i, f);
        }
        isSorted = true;
        return count;
    }

    public int insertSort() {
        int count = 0;
        int in;
        for (int out = 1; out < size; out++) {
            int temp = arr[out];
            in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
                in--;
            }
            arr[in] = temp;
        }
        isSorted = true;
        return count;
    }

    public int getMax() {
        if (size == 0) throw new RuntimeException("Empty array");
        if (size == 1) return arr[0];
        int r = arr[0];
        for (int i = 1; i < size; i++) {
            if (r < arr[i]) r = arr[i];
        }
        return r;
    }

    public int getMin() {
        if (size == 0) throw new RuntimeException("Empty array");
        if (size == 1) return arr[0];
        int r = arr[0];
        for (int i = 1; i < size; i++) {
            if (r > arr[i]) r = arr[i];
        }
        return r;
    }

    public void pigeonHoleSort() {
        int min = getMin();
        int max = getMax();
        int[] freq = new int[max - min + 1];
        for (int i = 0; i < size; i++) freq[arr[i] - min]++;

        int arrIndex = 0;
        for (int i = 0; i < freq.length; i++) {
            for (int elems = freq[i]; elems > 0; elems--) {
                arr[arrIndex++] = i + min;
            }
        }
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
