package AlgorithmsAndDatastructures.Sorts;

import java.util.Arrays;

public class QSort {
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void qSort(int[] arr, int min, int max) {
        int left = min;
        int right = max;
        int middle = arr[(left + right) / 2];

        do {
            while (arr[left] < middle) left++; // смотрим значения, которые меньше опорного и проскакиваем их
            while (arr[right] > middle) right--; // тут также
            if (left <= right) {
                if (arr[left] > arr[right]) {
                    swap(arr, left, right);
                }
                left++;
                right--;
            }
        } while (left <= right);

        if (left < max) qSort(arr, left, max);
        if (right > min) qSort(arr, min, right);
    }

    public static void main(String[] args) {
        int[] arr = {12, 54, 56, 87, 34, 65, 9, 89, 67, 65, 80, 76};
        System.out.println(Arrays.toString(arr));
        qSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}