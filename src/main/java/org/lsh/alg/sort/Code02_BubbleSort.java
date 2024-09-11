package org.lsh.alg.sort;

import org.lsh.alg.util.AlgUtils;

import java.util.Arrays;

public class Code02_BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{14, 44, 22, 61, 42, 3, 30, 12, 6, 32, 98, 21, 23, 231, 5, 76, 33, 87, 43};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    AlgUtils.swap(arr, j, j + 1);
                }
            }
        }
    }
}
