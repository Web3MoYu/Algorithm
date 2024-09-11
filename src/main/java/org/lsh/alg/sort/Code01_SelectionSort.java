package org.lsh.alg.sort;


import java.util.Arrays;

public class Code01_SelectionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{14, 44, 22, 61, 42, 3, 30, 12, 6, 32, 98, 21, 23, 231, 5, 76, 33, 87, 43};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int minIndex) {
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }

}
