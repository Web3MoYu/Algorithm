package org.lsh.alg.array.sort;

import org.lsh.alg.util.AlgUtils;

import java.util.Arrays;

public class C05_QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 6, 3, 4, 5, 2, 6, 9, 0};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            AlgUtils.swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1);
            quickSort(arr, p[1] + 1, R);
        }

    }

    private static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        while (L < more) {
            if (arr[L] < arr[R]) {
                AlgUtils.swap(arr, L++, ++less);
            } else if (arr[L] > arr[R]) {
                AlgUtils.swap(arr, L, --more);
            } else {
                L++;
            }

        }
        AlgUtils.swap(arr, more, R);
        return new int[]{less + 1, more};
    }
}
