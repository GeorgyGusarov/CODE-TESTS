package AlgorithmsAndDatastructures.Searches;

public class HalfDivisionSearch {
    public static void main(String[] args) {
        CustomArray array = new CustomArray(9, 6, 4, 2, 7, 3, 5, 1, 8, 10);
        array.bubbleSort();
        System.out.println(array.toString());
        System.out.println(array.hasValue(11));
    }
}

class CustomArray {
    private int[] arr;
    private int size;
    private boolean isSorted;

    public CustomArray(int... args) {
        this.size = args.length;
        this.arr = args;
        this.isSorted = false;
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
        isSorted = true;
    }

    // HalfDivisionSearch - works only on sorted array
    public boolean hasValue(int value) {
        if (!isSorted) throw new RuntimeException("try the 'find()' method");
        int l = 0;
        int r = size;
        int m;  // m = (l+r)/2, например: 5 + 10 / 2 = 7
        while (l < r) {
            m = (l + r) / 2;
            if (value == arr[m]) {
                return true;
            } else if (value < arr[m]) {
                r = m;
            } else if (value > arr[m]) {
                l = m + 1;
            }
        }
        return false;
    }
}
