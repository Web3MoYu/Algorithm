package org.lsh.alg.sort;

import org.lsh.alg.util.AlgUtils;

import java.util.Arrays;

public class Code03_InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[]{14, 14, 44, 22, 61, 42, 3, 30, 12, 6, 32, 98, 21, 23, 231, 5, 76, 33, 87, 43};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                AlgUtils.swap(arr, j, j - 1);
            }
        }
    }
}
