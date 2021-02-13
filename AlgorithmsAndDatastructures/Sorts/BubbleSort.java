package AlgorithmsAndDatastructures.Sorts;

public class BubbleSort {
    private int[] arr;
    private int size;

    public static void main(String[] args) {
        BubbleSort array = new BubbleSort(9, 6, 4, 2, 7, 3, 5, 1, 8);
        array.bubbleSort();
        System.out.println(array.toString());
    }

    public BubbleSort(int... args) {
        this.size = args.length;
        this.arr = args;
    }

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

    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void bubbleSort() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (arr[j] > arr[j + 1]) swap(j, j + 1);
            }
        }
    }
}
