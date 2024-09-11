package org.lsh.alg.sort;

import java.util.Arrays;

public class Code04_MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{14, 44, 22, 61, 42, -3, -30, 12, 6, 32, 98, 21, 23, 231, 5, 76, 33, 87, 43};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        mergeSort(arr, L, mid);
        mergeSort(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int[] res = new int[R - L + 1];
        int i = 0, p1 = L, p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            res[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            res[i++] = arr[p1++];
        }
        while (p2 <= R) {
            res[i++] = arr[p2++];
        }
        for (i = 0; i < res.length; i++) {
            arr[L + i] = res[i];
        }
    }
}
