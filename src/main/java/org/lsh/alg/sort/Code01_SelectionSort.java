package org.lsh.alg.sort;


import org.lsh.alg.util.AlgUtils;

import java.util.Arrays;

public class Code01_SelectionSort {

    public static void main(String[] args) {
        int maxSize = 10000;
        int maxValue = 100000;
        for (int i = 0; i < 100; i++) {
            int[] arr1 = AlgUtils.generateRandomArray(maxSize, maxValue);
            int[] arr2 = arr1.clone();
            Arrays.sort(arr2);
            selectionSort(arr1);
            if (!AlgUtils.compare(arr1, arr2)) {
                System.out.println(Arrays.toString(arr1));
                System.out.println(Arrays.toString(arr2));
                break;
            }
        }

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
            AlgUtils.swap(arr, i, minIndex);
        }
    }

}
