package AlgorithmsAndDatastructures;

public class SelectSort {
    private int[] arr;
    private int size;

    public static void main(String[] args) {
        SelectSort array = new SelectSort(9, 6, 4, 2, 7, 3, 5, 1, 8);
        array.selectSort();
        System.out.println(array.toString());
    }

    public SelectSort(int... args) {
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

    public void selectSort() {
        for (int flag = 0; flag < size; flag++) {
            int currentMin = flag;
            for (int rem = flag + 1; rem < size; rem++) {
                if (arr[rem] < arr[currentMin]) currentMin = rem;
            }
            swap(flag, currentMin);
        }
    }
}
