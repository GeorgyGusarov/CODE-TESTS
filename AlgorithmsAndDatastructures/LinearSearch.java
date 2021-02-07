package AlgorithmsAndDatastructures;

public class LinearSearch {
    private int[] arr;
    private int size;

    private int find(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) return i;
        }
        return -1;
    }
}
