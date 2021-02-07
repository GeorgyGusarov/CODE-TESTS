package AlgorithmsAndDatastructures;

public class InsertSort {
    private int[] arr;
    private int size;

    public static void main(String[] args) {
        InsertSort array = new InsertSort(9, 6, 4, 2, 7, 3, 5, 1, 8);
        array.insertSort();
        System.out.println(array.toString());
    }

    public InsertSort(int... args) {
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

    public void insertSort() {
        for (int out = 0; out < size; out++) {
            int temp = arr[out];
            int in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
                in--;
            }
            arr[in] = temp;
        }
    }
}
